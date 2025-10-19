package com.guillermogonzalezs.rsv.facturaRecibida.application;



import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.FacturaRecibidaMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFacturaRecibidaService {
    @Autowired
    private FacturaRecibidaMybatis mapper;

    public List<FacturaRecibida> obtenerTodos() {
        return mapper.findAll();
    }
    public FacturaRecibida obtenerPorId(Integer id) {
        return mapper.findById(id);
    }




}
    
