package com.guillermogonzalezs.rsv.producto.infrastructure.rest;


import com.guillermogonzalezs.rsv.producto.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

    @Autowired
    ProductoRestService service;

    @GetMapping("")
    public List<Producto> queryAll() {
        return service.obtenerTodos();

    }

}