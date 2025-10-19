package com.guillermogonzalezs.rsv.contrato.application;



import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.contrato.infrastructure.myBatis.ContratoMybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersistContratoService {
    @Autowired
    private ContratoMybatisRepository mapper;

    public void grabar(Contrato con, Cliente cli) {
                mapper.create(con, cli);
    }




}
    
