package com.guillermogonzalezs.rsv.producto.application;


import com.guillermogonzalezs.rsv.producto.domain.Producto;
import com.guillermogonzalezs.rsv.producto.domain.ProductoRepository;
import com.guillermogonzalezs.rsv.producto.infrastructure.myBatis.ProductoMybatis;
import com.guillermogonzalezs.rsv.producto.domain.Producto;
import com.guillermogonzalezs.rsv.producto.domain.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductoService {
    private ProductoRepository repository;


    private ProductoMybatis mapper;

    public FindProductoService(ProductoMybatis mapper) {
        this.mapper = mapper;
    }

    public Producto obtenerPorId(Integer productoId) {
        return mapper.findById(productoId);
    }
    public List<Producto> obtenerTodos() {
        return mapper.findAll();
    }


}
    
