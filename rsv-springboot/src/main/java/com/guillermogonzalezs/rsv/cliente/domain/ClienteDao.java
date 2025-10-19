package com.guillermogonzalezs.rsv.cliente.domain;

import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;

import java.util.List;

public interface ClienteDao {
    Integer getId();
    void create(Cliente cliente);
    void update(Cliente  cliente);
    void delete(Integer id);
    List<Cliente> findAll();
    Cliente findById(Integer idCliente);

}