package com.guillermogonzalezs.rsv.s3.domain;

import jdk.jfr.DataAmount;

import javax.persistence.Entity;


public class Curso {
    private Integer id;
    private String imagenPath;
    private String imagenUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
