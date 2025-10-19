package com.guillermogonzalezs.rsv.factura.application;

import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaMybatis mapper;

    public Integer siguienteCodigo(Integer serieId) {
        Integer cod =  mapper.siguienteCodigo(serieId);
        Integer codigo = ( cod == null) ? 1 :  cod;
        return codigo;
    }


}
