package com.guillermogonzalezs.rsv.factura.application;

import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.FindMovimientoService;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.contrato.application.FindContratoService;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import com.guillermogonzalezs.rsv.factura.infrastructure.pdf.FacturaPdf;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaMybatis;
import com.guillermogonzalezs.rsv.producto.application.FindProductoService;
import com.guillermogonzalezs.rsv.producto.domain.Producto;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;


@Service
public class PersistFacturaService {


    @Autowired
    private FacturaMybatis mapper;

    @Autowired
    private FindContratoService contratoService;

    @Autowired
    private FindProductoService productoService;

    @Autowired
    private FindMovimientoService movimientoService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private FacturaPdf facturaPdf;

    @Value("${s3BucketFacturas}")
    private String s3BucketFacturas;

    public void grabarFacturaAutomatica(Integer contratoId, Integer serieId, Date fecha) throws Exception {
        try {
            Contrato c = contratoService.obtenerPorId(contratoId);
            Factura f = new Factura();
            Producto p = productoService.obtenerPorId(c.getProductoId());
            List<Item> items = new ArrayList<Item>();
            Item i = new Item();

            f.setFecha(fecha);
            f.setSerieId(serieId);
            f.setUUID(String.valueOf(UUID.randomUUID()));
            f.setCodigo(this.facturaService.siguienteCodigo(serieId));
            f.setNombre(c.getTitularFactura());
            f.setNif(c.getNIFFactura());
            f.setDireccion(c.getDireccionFactura());
            f.setPoblacion(c.getPoblacionFactura());
            f.setCpostal(c.getCpostalFactura());
            f.setEstadoFacturaId(1);
            f.setContratoId(c.getId());
            f.setS3Bucket(f.getS3Bucket());
            f.setS3Key(f.getS3Key());

            i.setFacturaId(f.getId());
            i.setBase(c.getImporteAlquiler());
            i.setDescripcion(p.getDescripcion());
            i.setIva(c.getImporteAlquiler().multiply(c.getPorcentajeIva().divide(BigDecimal.valueOf(100))) );
            i.setIrpf(c.getImporteAlquiler().multiply(c.getPorcentajeIrpf().divide(BigDecimal.valueOf(100))) );
            items.add(i);

            f.setItems(items);

            this.mapper.grabarFacturaAutomatica(f);
            this.mapper.grabarItemAutomatico(f);
            Factura f2 = mapper.findByUUID(f.getUUID());

            byte[] pdfByte = facturaPdf.crearfacturaPdf(f2);
            addS3(f2, pdfByte);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void addS3(Factura f, byte[] pdfBytes) {

        String nombreFichero = f.getSerieNombre() + "-" +  String.format("%0" + 3 + "d", f.getCodigo()) + ".pdf";
        LocalDate localDate = f.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy"); // Formato de año con cuatro dígitos
        String year = localDate.format(formatter);
        String bucketName = s3BucketFacturas + "/" + year;
        MultipartFile pdfFile = new MockMultipartFile("file", nombreFichero, "application/pdf", pdfBytes);
        String key = s3Service.putObject(pdfFile, bucketName);
        // Actualizar objeto Factura
        f.setS3Key(key);
        f.setS3Bucket(bucketName);
        this.mapper.update(f);
    }


    public Factura grabarFacturaIndividual(Factura f) throws Exception {
        try {
            f.setCodigo(this.facturaService.siguienteCodigo(f.getSerieId()));
            f.setUUID(String.valueOf(UUID.randomUUID()));


            for (Item i : f.getItems()) {
                if (i.getBase() == null) {
                    i.setBase(BigDecimal.ZERO);
                }
                if (i.getIrpf() == null) {
                    i.setIrpf(BigDecimal.ZERO);
                }
                if (i.getIva() == null) {
                    i.setIva(BigDecimal.ZERO);
                }
            }

            this.mapper.grabarFacturaAutomatica(f);
            this.mapper.grabarItemAutomatico(f);
            Factura f2 = mapper.findByUUID(f.getUUID());

            byte[] pdfByte = facturaPdf.crearfacturaPdf(f2);
            addS3(f2, pdfByte);
            return f2;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }




    public void actualizar(Factura f) {
        this.mapper.update(f);
    }

    public void actualizarPorId(Factura f) {
        this.mapper.updateById(f);
    }

    public void cobrarFactura(Integer idFactura, Integer idMovimiento) throws Exception {
        Factura factura = mapper.findById(idFactura);
        Movimiento movimiento = movimientoService.obtenerPorId(idMovimiento);

        if (factura.getEstadoFacturaId() != 1) {
            throw  new Exception("Esta factura no puede se puesta como cobrada");
        }

        factura.setFechaCobro(movimiento.getFechaOperacion());
        factura.setEstadoFacturaId(2);
         mapper.update(factura);
    }



}
