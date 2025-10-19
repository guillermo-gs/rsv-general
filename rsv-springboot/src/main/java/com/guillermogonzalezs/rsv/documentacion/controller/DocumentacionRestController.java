package com.guillermogonzalezs.rsv.documentacion.controller;

import com.guillermogonzalezs.rsv.documentacion.entity.Documentacion;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import com.guillermogonzalezs.rsv.documentacion.service.DocumentacionService;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/documento")
public class DocumentacionRestController {

    @Autowired
    private DocumentacionService service;

    @Autowired
    private S3Service s3Service;


    @GetMapping("")
    public List<Documentacion> obtenerTodos() {
        return service.obtenerTodos();
    }


    @GetMapping("/tipos")
    public List<DocumentacionTipo> obtenerTipos() {
        return service.obtenerTipos();
    }


    @PostMapping(value= "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // //new annotation since 4.3
    public Documentacion singleFileUpload(
            @RequestPart String nombre,
            @RequestPart String tipoDocumentoId,
            @RequestPart String fechaDocumento,
            @RequestPart String descripcion,
            @RequestPart MultipartFile fichero,
            @RequestPart MultipartFile contratoId,
            @RequestPart MultipartFile productoId
            ) throws Exception {

            Documentacion doc = new Documentacion();
            doc.setNombre(nombre);
            doc.setTipoDocumentoId(Integer.parseInt(tipoDocumentoId));
            doc.setDescripcion(descripcion);

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date fd = simpleDateFormat.parse(fechaDocumento);
            doc.setFechaDocumento(fd);
            doc.setDescripcion(descripcion);

            Documentacion docGuardada = service.crear(doc, fichero);
            return docGuardada;


//        LocalDate localDate = f2.getFechaFactura().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        String nombreFichero = String.format("%05d", f2.getId()) + "-" + localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))  + "-" + S3Utils.normalizeFileName(f2.getProveedor(), fichero.getOriginalFilename());
//        String bucketName = s3BucketFacturasRecibidas + "/" + localDate.format(DateTimeFormatter.ofPattern("yyyy"));
//        byte[] pdfByte = fichero.getBytes();
//        MultipartFile pdfFile = new MockMultipartFile("file", nombreFichero, "application/pdf", pdfByte);
//        String key = s3Service.putObject(pdfFile, bucketName);
//        f2.setS3Bucket(bucketName);
//        f2.setS3Key(key);
//        service.actualizarSinFichero(f2);


    }


}



