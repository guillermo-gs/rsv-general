package com.guillermogonzalezs.rsv.factura.domain.entities;

import java.math.BigDecimal;
import java.util.Date;


public class Item {
    private Integer id;
    private Integer facturaId;
    private String descripcion;
    private BigDecimal base;
    private BigDecimal iva;
    private BigDecimal irpf;


    public Item() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getIrpf() {
        return irpf;
    }

    public void setIrpf(BigDecimal irpf) {
        this.irpf = irpf;
    }
}
