package com.guillermogonzalezs.rsv.producto.infrastructure.rest;

import com.guillermogonzalezs.rsv.producto.application.FindProductoService;
import com.guillermogonzalezs.rsv.producto.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoRestService {

    @Autowired
    FindProductoService service;


    public List<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }
}