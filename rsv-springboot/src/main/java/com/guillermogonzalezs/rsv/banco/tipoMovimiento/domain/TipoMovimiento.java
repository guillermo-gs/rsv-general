package com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain;




public class TipoMovimiento{
    private Integer id;
    private String nombre;
    private Boolean activo;
    private String gastoIngreso;
    private Boolean imputableContrato;
    private Boolean imputableInmueble;

    public TipoMovimiento() {

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getGastoIngreso() {
        return gastoIngreso;
    }

    public void setGastoIngreso(String gastoIngreso) {
        this.gastoIngreso = gastoIngreso;
    }

    public Boolean getImputableContrato() {
        return imputableContrato;
    }

    public void setImputableContrato(Boolean imputableContrato) {
        this.imputableContrato = imputableContrato;
    }

    public Boolean getImputableInmueble() {
        return imputableInmueble;
    }

    public void setImputableInmueble(Boolean imputableInmueble) {
        this.imputableInmueble = imputableInmueble;
    }
}
