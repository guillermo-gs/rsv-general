package com.guillermogonzalezs.rsv.producto.infrastructure.myBatis;

import com.guillermogonzalezs.rsv.producto.domain.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProductoMybatis {

    List<Producto> findAll();
    Producto findById(@Param("id") Integer id);



}