package com.guillermogonzalezs.rsv.producto.domain;


import java.math.BigDecimal;
import java.util.Date;

public class Producto {


    private Integer id;
    private Boolean activo;
    private Boolean alquilable;
    private Integer productoId;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaRenovacion;
    private BigDecimal importeAlquiler;
    private String inquilino;
    private Boolean libre;
    private Integer metrosCatastral;
    private String nombre;
    private String referenciaCatastral;
    private Boolean tieneHipoteca;
    private String usoCatastral;
    private Integer usuarioId;


    public Producto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getAlquilable() {
        return alquilable;
    }

    public void setAlquilable(Boolean alquilable) {
        this.alquilable = alquilable;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaRenovacion() {
        return fechaRenovacion;
    }

    public void setFechaRenovacion(Date fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }

    public BigDecimal getImporteAlquiler() {
        return importeAlquiler;
    }

    public void setImporteAlquiler(BigDecimal importeAlquiler) {
        this.importeAlquiler = importeAlquiler;
    }

    public String getInquilino() {
        return inquilino;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public Boolean getLibre() {
        return libre;
    }

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public Integer getMetrosCatastral() {
        return metrosCatastral;
    }

    public void setMetrosCatastral(Integer metrosCatastral) {
        this.metrosCatastral = metrosCatastral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }

    public void setReferenciaCatastral(String referenciaCatastral) {
        this.referenciaCatastral = referenciaCatastral;
    }

    public Boolean getTieneHipoteca() {
        return tieneHipoteca;
    }

    public void setTieneHipoteca(Boolean tieneHipoteca) {
        this.tieneHipoteca = tieneHipoteca;
    }

    public String getUsoCatastral() {
        return usoCatastral;
    }

    public void setUsoCatastral(String usoCatastral) {
        this.usoCatastral = usoCatastral;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}