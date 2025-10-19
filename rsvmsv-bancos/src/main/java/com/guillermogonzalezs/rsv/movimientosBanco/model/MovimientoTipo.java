package com.guillermogonzalezs.rsv.movimientosBanco.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movimientos_tipo")
@Data // incluye @Getter, @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Boolean activo;

    @Column(name = "gasto_ingreso")
    private String gastoIngreso;

    @Column(name = "imputable_contrato")
    private Boolean imputableContrato;

    @Column(name = "imputable_inmueble")
    private Boolean imputableInmueble;
}