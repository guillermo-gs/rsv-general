package com.guillermogonzalezs.rsv.cliente.application;


import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.cliente.domain.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistClienteService {

    @Autowired
    private ClienteDao clienteDao;


    public void actualizar(Cliente cliente) {
        this.clienteDao.update(cliente);
    }


}
