package com.guillermogonzalezs.rsv.cliente.infrastructure.service;

import com.guillermogonzalezs.rsv.cliente.application.FindClienteService;
import com.guillermogonzalezs.rsv.cliente.application.PersistClienteService;
import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.cliente.domain.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteRestService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private FindClienteService service;

    @Autowired
    private PersistClienteService persistService;


    public List<Cliente> obtenerTodos() {
        return service.obtenerTodos();
    }
    public Cliente obtenerPorId(Integer id) {
        return service.obtenerPorId(id);
    }
    public Cliente crear(Cliente obj) {
        clienteDao.create(obj);
        return obj;
    }

    public void actualizar(Cliente cliente) {
        this.persistService.actualizar(cliente);

    }


}