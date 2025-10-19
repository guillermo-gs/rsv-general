package com.guillermogonzalezs.rsv.contrato.domain;


import java.math.BigDecimal;
import java.util.Date;

public class Contrato {
    private Integer id;
    private Integer personaId;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaBaja;
    private Date fechaUltimaFactura;
    private Boolean pagoLuz;
    private Boolean pagoAgua;
    private Boolean pagoGas;
    private Boolean pagoAire;
    private Boolean pagoComunidad;
    private String observaciones;
    private BigDecimal importeAlquiler;
    private BigDecimal porcentajeIrpf;
    private BigDecimal porcentajeIva;
    private Date fechaRenovacion;
    private String documento;
    private Integer productoId;
    private Integer facturasImpagadas;
    private String personas;
    private Boolean activo;
    private String direccionFactura;
    private String poblacionFactura;
    private String cpostalFactura;
    private  String NIFFactura;
    private String titularFactura;
    private String personaDescripcion;


    public Contrato() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaUltimaFactura() {
        return fechaUltimaFactura;
    }

    public void setFechaUltimaFactura(Date fechaUltimaFactura) {
        this.fechaUltimaFactura = fechaUltimaFactura;
    }

    public Boolean getPagoLuz() {
        return pagoLuz;
    }

    public void setPagoLuz(Boolean pagoLuz) {
        this.pagoLuz = pagoLuz;
    }

    public Boolean getPagoAgua() {
        return pagoAgua;
    }

    public void setPagoAgua(Boolean pagoAgua) {
        this.pagoAgua = pagoAgua;
    }

    public Boolean getPagoGas() {
        return pagoGas;
    }

    public void setPagoGas(Boolean pagoGas) {
        this.pagoGas = pagoGas;
    }

    public Boolean getPagoAire() {
        return pagoAire;
    }

    public void setPagoAire(Boolean pagoAire) {
        this.pagoAire = pagoAire;
    }

    public Boolean getPagoComunidad() {
        return pagoComunidad;
    }

    public void setPagoComunidad(Boolean pagoComunidad) {
        this.pagoComunidad = pagoComunidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getImporteAlquiler() {
        return importeAlquiler;
    }

    public void setImporteAlquiler(BigDecimal importeAlquiler) {
        this.importeAlquiler = importeAlquiler;
    }

    public BigDecimal getPorcentajeIrpf() {
        return porcentajeIrpf;
    }

    public void setPorcentajeIrpf(BigDecimal porcentajeIrpf) {
        this.porcentajeIrpf = porcentajeIrpf;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Date getFechaRenovacion() {
        return fechaRenovacion;
    }

    public void setFechaRenovacion(Date fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getFacturasImpagadas() {
        return facturasImpagadas;
    }

    public void setFacturasImpagadas(Integer facturasImpagadas) {
        this.facturasImpagadas = facturasImpagadas;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDireccionFactura() {
        return direccionFactura;
    }

    public void setDireccionFactura(String direccionFactura) {
        this.direccionFactura = direccionFactura;
    }

    public String getPoblacionFactura() {
        return poblacionFactura;
    }

    public void setPoblacionFactura(String poblacionFactura) {
        this.poblacionFactura = poblacionFactura;
    }

    public String getCpostalFactura() {
        return cpostalFactura;
    }

    public void setCpostalFactura(String cpostalFactura) {
        this.cpostalFactura = cpostalFactura;
    }


    public String getNIFFactura() {
        return NIFFactura;
    }

    public void setNIFFactura(String NIFFactura) {
        this.NIFFactura = NIFFactura;
    }

    public String getTitularFactura() {
        return titularFactura;
    }

    public void setTitularFactura(String titularFactura) {
        this.titularFactura = titularFactura;
    }


    public String getPersonaDescripcion() {
        return this.descripcion + " - " + this.personas;
    }

    public void setPersonaDescripcion(String personaDescripcion) {
        this.personaDescripcion = personaDescripcion;
    }
}