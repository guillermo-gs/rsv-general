package com.guillermogonzalezs.rsv.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="bancos_movimientos_tipo")
public class BancoTipoMovimiento  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo;
    private String gastoIngreso;
    private Boolean imputableContrato;
    private Boolean imputableInmueble;

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

    private static final long serialVersionUID = 1L;
}
