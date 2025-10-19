package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.rest;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaMybatis;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.FacturaRecibidaMybatis;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service.FacturaRecibidaRestService;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import com.guillermogonzalezs.rsv.s3.domain.Asset;
import com.guillermogonzalezs.rsv.util.S3Utils;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/factura-recibida")
public class FacturaRecibidaRestController {

    @Autowired
    private FacturaRecibidaRestService service;

    @Autowired
    private S3Service s3Service;


    @GetMapping("")
    public List<FacturaRecibida> obtenerTodos() {
        return service.obtenerTodos();
    }

    @Value("${s3BucketFacturasRecibidas}")
    private String s3BucketFacturasRecibidas;




    @RequestMapping(path = "/download", method = RequestMethod.POST)
    // public ResponseEntity<Resource> downloadFile(@PathVariable Integer idFacturaRecibida) throws Exception
    public ResponseEntity<byte[]> getMergePdf(@RequestBody List<Integer> ids) throws Exception {
        try
        {

            PDFMergerUtility ut = new PDFMergerUtility();
            ByteArrayOutputStream pdfDocOutputstream = new ByteArrayOutputStream();
            String nombreDescarga = "facturas-recibidas.pdf";

            for (Integer id: ids) {
                FacturaRecibida f = service.obtenerPorId(id);
                LocalDate localDate = f.getFechaFactura().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy"); // Formato de año con cuatro dígitos
                String year = localDate.format(formatter);
                Asset asset = s3Service.getObject(f.getS3Bucket(), f.getS3Key());
                ut.addSource(new ByteArrayInputStream(asset.getContent()));
            }

            ut.setDestinationFileName(nombreDescarga);
            ut.setDestinationStream(pdfDocOutputstream);
            ut.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);

            headers.setContentDispositionFormData(ut.getDestinationFileName(), ut.getDestinationFileName());
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(pdfDocOutputstream.toByteArray(), headers, HttpStatus.OK);
            return response;

        }
        catch(Exception e)
        {
            throw new Exception("Error descargando el fichero");
        }
    }


    @RequestMapping(value = {"obtener-por-id/{idFacturaRecibida}" }, method = RequestMethod.GET)
    public FacturaRecibida obtenerPorId(@PathVariable Integer idFacturaRecibida) {
        return  service.obtenerPorId(idFacturaRecibida);
    }


    @PostMapping(value = "/actualizar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FacturaRecibida actualizar(
                                  @RequestPart String id,
                                  @RequestPart String estadoFacturaId,
                                  @RequestPart String accionFacturaId,
                                  @RequestPart String fechaFactura,
                                  @RequestPart String proveedor,
                                  @RequestPart String importe,
                                  @RequestPart String observaciones,
                                  @RequestPart MultipartFile fichero ) throws Exception {
        FacturaRecibida f = service.obtenerPorId(Integer.parseInt(id));

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(fechaFactura);

        f.setAccionFacturaId(Integer.parseInt(accionFacturaId));
        f.setEstadoFacturaId(Integer.parseInt(estadoFacturaId));
        f.setProveedor(proveedor);
        f.setObservaciones(observaciones);
        f.setFechaFactura(date);
        f.setFechaSubida(new Date());
        f.setUsuarioId(1);
        f.setContenido(fichero.getBytes());
        f.setImporte(new BigDecimal(importe));
        return service.actualizarConFichero(f);
    }

    @PostMapping(value = "/actualizar-sinpdf")
    public FacturaRecibida actualizarSinPdf(@RequestPart String id,
                                            @RequestPart String estadoFacturaId,
                                            @RequestPart String accionFacturaId,
                                            @RequestPart String fechaFactura,
                                            @RequestPart String proveedor,
                                            @RequestPart String importe,
                                            @RequestPart(value="observaciones", required = false) String observaciones
                                            ) throws ParseException {
        FacturaRecibida f = service.obtenerPorId(Integer.parseInt(id));

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(fechaFactura);

        f.setAccionFacturaId(Integer.parseInt(accionFacturaId));
        f.setEstadoFacturaId(Integer.parseInt(estadoFacturaId));
        f.setProveedor(proveedor);
        f.setObservaciones(observaciones);
        f.setFechaFactura(date);
        f.setFechaSubida(new Date());
        f.setUsuarioId(1);
        f.setImporte(new BigDecimal(importe));
        return service.actualizarSinFichero(f);

    }


    @PostMapping(value= "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // //new annotation since 4.3
    public void singleFileUpload(
                                    @RequestPart String estadoFacturaId,
                                    @RequestPart String accionFacturaId,
                                    @RequestPart String fechaFactura,
                                    @RequestPart String proveedor,
                                    @RequestPart String  importe,
                                    @RequestPart(required=false) String observaciones,
                                    @RequestPart MultipartFile fichero ) throws Exception {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        FacturaRecibida f = new FacturaRecibida();
        Date date = simpleDateFormat.parse(fechaFactura);

        String valorUUID = String.valueOf(UUID.randomUUID());
        f.setUUID(String.valueOf(UUID.randomUUID()));
        f.setAccionFacturaId(Integer.parseInt(accionFacturaId));
        f.setEstadoFacturaId(Integer.parseInt(estadoFacturaId));
        f.setProveedor(proveedor);
        f.setObservaciones(observaciones);
        f.setFechaFactura(date);
        f.setFechaSubida(new Date());
        f.setUsuarioId(1);
        f.setImporte(new BigDecimal(importe));
        f.setUUID(valorUUID);
        service.crear(f);
        FacturaRecibida f2 = service.obtenerPorUUID(valorUUID);

        LocalDate localDate = f2.getFechaFactura().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String nombreFichero = String.format("%05d", f2.getId()) + "-" + localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))  + "-" + S3Utils.normalizeFileName(f2.getProveedor(), fichero.getOriginalFilename());
        String bucketName = s3BucketFacturasRecibidas + "/" + localDate.format(DateTimeFormatter.ofPattern("yyyy"));
        byte[] pdfByte = fichero.getBytes();
        MultipartFile pdfFile = new MockMultipartFile("file", nombreFichero, "application/pdf", pdfByte);
        String key = s3Service.putObject(pdfFile, bucketName);
        f2.setS3Bucket(bucketName);
        f2.setS3Key(key);
        service.actualizarSinFichero(f2);


    }



    @RequestMapping(value="/show-pdf/{idFacturaRecibida}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF(@PathVariable Integer idFacturaRecibida) {
        FacturaRecibida f = service.obtenerPorId(idFacturaRecibida);
        byte[] contents = f.getContenido();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Here you have to set the actual filename of your pdf
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }


}