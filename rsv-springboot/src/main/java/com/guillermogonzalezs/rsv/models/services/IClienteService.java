package com.guillermogonzalezs.rsv.models.services;

import com.guillermogonzalezs.rsv.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();
 }
