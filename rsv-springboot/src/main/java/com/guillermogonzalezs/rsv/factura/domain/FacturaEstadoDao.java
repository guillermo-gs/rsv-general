package com.guillermogonzalezs.rsv.factura.domain;

import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaEstado;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;

import java.util.List;

public interface FacturaEstadoDao {
    List<FacturaEstado> findAll();
    FacturaEstado findById(Integer idFactura);


}