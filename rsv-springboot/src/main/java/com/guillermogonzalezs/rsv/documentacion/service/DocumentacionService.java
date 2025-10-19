package com.guillermogonzalezs.rsv.documentacion.service;



import com.guillermogonzalezs.rsv.documentacion.dao.DocumentacionDaoImp;
import com.guillermogonzalezs.rsv.documentacion.entity.Documentacion;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipoRel;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import com.guillermogonzalezs.rsv.util.S3Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentacionService {

    @Autowired
    private DocumentacionDaoImp mapper;

    @Autowired
    private S3Service s3Service;

    public List<Documentacion> obtenerTodos() {
        return mapper.findAll();
    }


    private static String NOMBRE_BUCKET = "rsvdocumentos";

    public Documentacion crear(Documentacion doc, MultipartFile fichero) throws IOException {
        List<DocumentacionTipo> dt = mapper.findTipos();
        Optional<DocumentacionTipo > tipo = dt.stream().filter(d -> d.getId().equals(doc.getTipoDocumentoId())).findFirst();

        byte[] pdfByte = fichero.getBytes();

        doc.setFechaInsercion(new Date());
        doc.setUUID(String.valueOf(UUID.randomUUID()));
        doc.setUsuarioInsercionId(1);
        // todo contrato y producto

        doc.setS3Key(doc.getNombre());
        doc.setS3Bucket(tipo.get().getS3Bucket());
        doc.setS3Key(S3Utils.normalizeFileName(doc.getS3Key(), fichero.getOriginalFilename()));
        // nombre. pendiente de cambiar espacos por guoines


        mapper.create(doc);
        MultipartFile pdfFile = new MockMultipartFile("file", doc.getS3Key(), "application/pdf", pdfByte);
        s3Service.putObject(pdfFile, doc.getS3Bucket());
        this.relacionar(doc.getUUID(), doc.getTipoDocumentoId());
        return doc;
    }

    private DocumentacionTipoRel relacionar(String UUID, Integer tipoId) {
        DocumentacionTipoRel rel = new DocumentacionTipoRel(UUID, tipoId);
        mapper.relacionarTipo(rel);
        return rel;
    }

    public Documentacion obtenerPorUUID(String uuid) {
        return mapper.obtenerPorUUID(uuid);
    }

    public List<DocumentacionTipo> obtenerTipos() {
        return mapper.findTipos();
    }



}
    
