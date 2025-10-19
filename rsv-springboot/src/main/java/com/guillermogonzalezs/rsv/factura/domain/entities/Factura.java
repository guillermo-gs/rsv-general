package com.guillermogonzalezs.rsv.factura.domain.entities;


import com.guillermogonzalezs.rsv.factura.application.FindFacturaService;
import com.guillermogonzalezs.rsv.factura.domain.FacturaDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Factura {


    private Integer id;
    private String UUID;
    private Integer serieId;
    private String serieTipo;
    private String serieNombre;
    private Integer codigo;
    private Date fecha;
    private String nombre;
    private String nif;
    private String descripcion;
    private String cuentaBancaria;
    private Integer estadoFacturaId;
    private Integer contratoId;
    private Date fechaCobro;
    private String observaciones;
    private String direccion;
    private String poblacion;
    private String cpostal;
    private BigDecimal base;
    private BigDecimal iva;
    private BigDecimal total;
    private BigDecimal irpf;

    private List<Item> items;
    private String  pdf;

    private String s3Bucket;
    private String s3Key;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Integer getSerieId() {
        return serieId;
    }


    public String getSerieTipo() {
        return serieTipo;
    }

    public void setSerieTipo(String serieTipo) {
        this.serieTipo = serieTipo;
    }

    public String getSerieNombre() {
        return serieNombre;
    }

    public void setSerieNombre(String serieNombre) {
        this.serieNombre = serieNombre;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getEstadoFacturaId() {
        return estadoFacturaId;
    }

    public void setEstadoFacturaId(Integer estadoFacturaId) {
        this.estadoFacturaId = estadoFacturaId;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIrpf() {
        return irpf;
    }

    public void setIrpf(BigDecimal irpf) {
        this.irpf = irpf;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getS3Bucket() {
        return s3Bucket;
    }

    public void setS3Bucket(String s3Bucket) {
        this.s3Bucket = s3Bucket;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }
}
