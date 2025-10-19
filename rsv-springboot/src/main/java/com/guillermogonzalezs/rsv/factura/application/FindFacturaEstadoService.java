package com.guillermogonzalezs.rsv.factura.application;

import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaEstado;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaEstadoMybatis;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaSerieMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFacturaEstadoService {


    @Autowired
    private FacturaEstadoMybatis mapper;

    public List<FacturaEstado> obtenerTodos() {
        return mapper.findAll();
    }

}
