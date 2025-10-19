package com.guillermogonzalezs.rsv.banco.movimiento.domain;


import java.math.BigDecimal;
import java.util.Date;

public class Movimiento {
    private Integer id;
    private Integer tipoMovimientoId;
    private Integer concepto;
    private Integer contratoId;
    private String  cuenta;
    private String detalle;
    private Date fechaOperacion;
    private Date fechaValor;
    private BigDecimal importe;
    private String observaciones;
    private Integer productoId;
    private String referencia1;
    private String referencia2;
    private Integer facturaRecibidaId;
    private String debeHaber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public void setTipoMovimientoId(Integer tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
    }

    public Integer getConcepto() {
        return concepto;
    }

    public void setConcepto(Integer concepto) {
        this.concepto = concepto;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Date getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(Date fechaValor) {
        this.fechaValor = fechaValor;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public Integer getFacturaRecibidaId() {
        return facturaRecibidaId;
    }

    public void setFacturaRecibidaId(Integer facturaRecibidaId) {
        this.facturaRecibidaId = facturaRecibidaId;
    }

    public Movimiento() {}

    public String getDebeHaber() {
        return debeHaber;
    }

    public void setDebeHaber(String debeHaber) {
        this.debeHaber = debeHaber;
    }
}
