package com.guillermogonzalezs.rsv.producto.infrastructure;

import com.guillermogonzalezs.rsv.producto.domain.Producto;
import com.guillermogonzalezs.rsv.producto.domain.ProductoRepository;
import com.guillermogonzalezs.rsv.producto.infrastructure.myBatis.ProductoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoRepositoryImp implements ProductoRepository {
    @Autowired
    ProductoMybatis repository;


    @Override
    public Producto findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }


}   