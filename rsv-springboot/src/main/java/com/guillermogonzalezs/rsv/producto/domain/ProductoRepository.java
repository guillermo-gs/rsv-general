package com.guillermogonzalezs.rsv.producto.domain;


import java.util.List;

public interface ProductoRepository {

    Producto findById(Integer id);
    List<Producto> findAll();



}