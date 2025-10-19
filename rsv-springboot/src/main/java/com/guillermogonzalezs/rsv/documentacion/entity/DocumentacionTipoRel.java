package com.guillermogonzalezs.rsv.documentacion.entity;


import java.util.Date;

public class DocumentacionTipoRel {

    String UUIDDocu;
    Integer tipoDocumentoId;

    public DocumentacionTipoRel(String UUIDDocu, Integer tipoDocumentoId) {
        this.UUIDDocu = UUIDDocu;
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getUUIDDocu() {
        return UUIDDocu;
    }

    public void setUUIDDocu(String UUIDDocu) {
        this.UUIDDocu = UUIDDocu;
    }

    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }
}