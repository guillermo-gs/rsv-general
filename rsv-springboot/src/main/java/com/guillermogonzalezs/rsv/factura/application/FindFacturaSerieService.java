package com.guillermogonzalezs.rsv.factura.application;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaMybatis;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaSerieMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFacturaSerieService {

    @Autowired
    private FacturaSerieMybatis mapper;

    public List<FacturaSerie> obtenerTodos() {
        return mapper.findAll();
    }

}
