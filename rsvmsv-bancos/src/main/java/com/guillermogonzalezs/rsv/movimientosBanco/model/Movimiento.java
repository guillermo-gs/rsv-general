package com.guillermogonzalezs.rsv.movimientosBanco.model;

import lombok.Data;

@Data
public class Movimiento {
    private Long id;
    private Integer tipoMovimientoId;
    private String concepto;
    private Long contratoId;
    private String cuenta;
    private String detalle;
    private Long fechaOperacion;
    private Long fechaValor;
    private Double importe;
    private String observaciones;
    private Long productoId;
    private String referencia1;
    private String referencia2;
    private Long facturaRecibidaId;
    private String debeHaber;
}
