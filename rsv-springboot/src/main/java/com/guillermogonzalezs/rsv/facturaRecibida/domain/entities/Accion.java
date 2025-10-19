package com.guillermogonzalezs.rsv.facturaRecibida.domain.entities;


import java.math.BigDecimal;
import java.util.Date;

public class Accion {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean activo;


    public Accion() {

    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}