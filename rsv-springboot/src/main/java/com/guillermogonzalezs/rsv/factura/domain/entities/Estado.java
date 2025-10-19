package com.guillermogonzalezs.rsv.factura.domain.entities;

import java.util.Date;


public class Estado {
    private Integer id;
    private String nombre;
    private Boolean activo;


    public Estado() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
