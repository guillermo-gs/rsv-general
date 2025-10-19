package com.guillermogonzalezs.rsv.factura.domain;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;

import java.util.Date;
import java.util.List;

public interface FacturaSerieDao {
    List<FacturaSerie> findAll();
    FacturaSerie findById(Integer idFactura);


}