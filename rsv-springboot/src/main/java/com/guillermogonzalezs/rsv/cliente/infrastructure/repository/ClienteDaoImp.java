package com.guillermogonzalezs.rsv.cliente.infrastructure.repository;

import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.cliente.domain.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDaoImp implements ClienteDao {

    @Autowired
    ClienteMybatis repository;

    @Autowired private ClienteDao clienteDao;


    @Override
    public Cliente findById(Integer idCliente) {
        return this.clienteDao.findById(idCliente);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void create(Cliente cliente) {
        repository.create(cliente);
    }

    @Override
    public void update(Cliente cliente) {

         repository.update(cliente);
    }
    @Override
    public void delete(Integer id) {

        repository.delete(id);
    }

}