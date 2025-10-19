package com.guillermogonzalezs.rsv.dto;

import com.guillermogonzalezs.rsv.models.entity.BancoTipoMovimiento;

import java.math.BigDecimal;
import java.util.Date;

public class BancoTipoMovimientoDto {

    private Long id;
    private String nombre;
    private Boolean activo;
    private String gastoIngreso;
    private Boolean imputableContrato;
    private Boolean imputableInmueble;

    public BancoTipoMovimientoDto() { }

    public BancoTipoMovimientoDto(final BancoTipoMovimiento bancoTipoMovimiento) {
        this.id = bancoTipoMovimiento.getId();
        this.nombre = bancoTipoMovimiento.getNombre();
        this.activo = bancoTipoMovimiento.getActivo();
        this.gastoIngreso = bancoTipoMovimiento.getGastoIngreso();
        this.imputableContrato = bancoTipoMovimiento.getImputableContrato();
        this.imputableInmueble = bancoTipoMovimiento.getImputableInmueble();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
