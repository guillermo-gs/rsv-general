package com.guillermogonzalezs.rsv.factura.infrastructure.rest;

import com.guillermogonzalezs.rsv.factura.application.PersistFacturaService;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.infrastructure.pdf.FacturaPdf;
import com.guillermogonzalezs.rsv.factura.infrastructure.service.FacturaRestService;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import com.guillermogonzalezs.rsv.s3.domain.Asset;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/factura")
public class FacturaRestController {

    @Autowired
    private FacturaRestService service;
    @Autowired
    private PersistFacturaService persistFacturaService;

    @Autowired
    private FacturaPdf facturaPdf;
    @Autowired
    private S3Service s3Service;


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Factura> obtenerTodos() {
        return service.obtenerTodos();
    }

    @RequestMapping(value = {"/grabar-automatica/{contratoId}/{serieId}/{fecha}"}, method = RequestMethod.GET)
    public void grabar(@PathVariable Integer contratoId, @PathVariable Integer serieId, @PathVariable String fecha) throws ParseException {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            persistFacturaService.grabarFacturaAutomatica(contratoId, serieId, date);
        } catch (Exception e) {
            // FIXME: Comprobar el 12
            throw new ParseException(e.getMessage(), 12);
        }

    }


    @PostMapping(value = "/grabar-individual")
    public Factura grabarIndividual(@RequestBody Factura factura) throws Exception {
        return persistFacturaService.grabarFacturaIndividual(factura);
    }

    @PostMapping(value = "/cobrar")
    public Factura cobrarFactura(@RequestBody Map<String, Object> payload) throws Exception {
        Integer facturaId = (Integer) payload.get("facturaId");
        Integer movimientoId = (Integer) payload.get("movimientoId");
        persistFacturaService.cobrarFactura(facturaId, movimientoId);
        return service.obtenerPorId(facturaId);
    }


    @RequestMapping(value = {"/recalculars3"}, method = RequestMethod.GET)
    public void recalculars3() throws Exception {

        for (Integer i = 379; i <= 1326; i++) {
            Factura f = service.obtenerPorId(i);
            if (f != null) {
                f.setS3Bucket("rsvfacturas-bucket");
                f.setS3Key(f.getSerieNombre() + "-" + String.format("%0" + 3 + "d", f.getCodigo()) + ".pdf");
                f.setUUID(String.valueOf(UUID.randomUUID()));
                persistFacturaService.actualizarPorId(f);
                facturaPdf.crearfacturaPdf(f);
                byte[] pdfByte = facturaPdf.crearfacturaPdf(f);
                persistFacturaService.addS3(f, pdfByte);
            }
        }
    }


    @RequestMapping(path = "/download", method = RequestMethod.POST)
    // public ResponseEntity<Resource> downloadFile(@PathVariable Integer idFacturaRecibida) throws Exception
    public ResponseEntity<byte[]> getMergePdf(@RequestBody List<Integer> ids) throws Exception {
        try {

            PDFMergerUtility ut = new PDFMergerUtility();
            ByteArrayOutputStream pdfDocOutputstream = new ByteArrayOutputStream();
            String hhh = "facturas-recibidas.pdf";

            for (Integer id : ids) {
                Factura f = service.obtenerPorId(id);
                LocalDate localDate = f.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy"); // Formato de año con cuatro dígitos
                Asset asset = s3Service.getObject(f.getS3Bucket(), f.getS3Key());
                ut.addSource(new ByteArrayInputStream(asset.getContent()));
            }

            ut.setDestinationFileName(hhh);
            ut.setDestinationStream(pdfDocOutputstream);
            ut.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);

            headers.setContentDispositionFormData(ut.getDestinationFileName(), ut.getDestinationFileName());
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(pdfDocOutputstream.toByteArray(), headers, HttpStatus.OK);
            return response;

        } catch (Exception e) {
            throw new Exception("Error descargando el fichero");
        }
    }
}

