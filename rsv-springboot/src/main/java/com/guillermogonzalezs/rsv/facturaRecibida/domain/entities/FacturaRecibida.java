package com.guillermogonzalezs.rsv.facturaRecibida.domain.entities;


import java.math.BigDecimal;
import java.util.Date;

public class FacturaRecibida {

    private Integer id;
    private Integer estadoFacturaId;
    private String estadoFacturaNombre;
    private Integer usuarioId;
    private byte[]  contenido;
    private Date fechaFactura;
    private Date fechaSubida;
    private String observaciones;
    private String proveedor;
    private BigDecimal importe;
    private Integer accionFacturaId;
    private String accionFacturaNombre;

    private Integer contratoId;
    private String s3Bucket;
    private String s3Key;
    private String UUID;
    public FacturaRecibida() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstadoFacturaId() {
        return estadoFacturaId;
    }

    public void setEstadoFacturaId(Integer estadoFacturaId) {
        this.estadoFacturaId = estadoFacturaId;
    }

    public String getEstadoFacturaNombre() {
        return estadoFacturaNombre;
    }

    public void setEstadoFacturaNombre(String estadoFacturaNombre) {
        this.estadoFacturaNombre = estadoFacturaNombre;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Integer getAccionFacturaId() {
        return accionFacturaId;
    }

    public void setAccionFacturaId(Integer accionFacturaId) {
        this.accionFacturaId = accionFacturaId;
    }

    public String getAccionFacturaNombre() {
        return accionFacturaNombre;
    }

    public void setAccionFacturaNombre(String accionFacturaNombre) {
        this.accionFacturaNombre = accionFacturaNombre;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
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

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}