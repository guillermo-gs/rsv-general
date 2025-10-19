package com.guillermogonzalezs.rsv.contrato.domain;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.models.entity.BancoMovimiento;

import java.util.List;

public interface ContratoDao {
    List<Contrato> findAll();
    Contrato findById(Integer idContrato);
    List<Contrato> findActivos();
    List<Movimiento> findMovimientos(Contrato contrato);
}