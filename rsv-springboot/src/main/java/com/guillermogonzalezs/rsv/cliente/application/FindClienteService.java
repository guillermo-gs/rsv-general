package com.guillermogonzalezs.rsv.cliente.application;



import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.cliente.infrastructure.repository.ClienteMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindClienteService {
    @Autowired
    private ClienteMybatis mapper;

    public List<Cliente> obtenerTodos() {
        return mapper.findAll();
    }
    public Cliente obtenerPorId(Integer id) {
        return mapper.findById(id);
    }




}
    
