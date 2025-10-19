package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.port.out;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;

public interface MovimientoPublisherPort {
    void publishCreated(Movimiento movimiento);
}