package com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain;

import java.util.List;

public interface TipoMovimientoRepository {
    List<TipoMovimiento> findAll();
}
