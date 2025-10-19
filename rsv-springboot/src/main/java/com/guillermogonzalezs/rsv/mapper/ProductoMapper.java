package com.guillermogonzalezs.rsv.mapper;

import com.guillermogonzalezs.rsv.producto.domain.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductoMapper {

    @Select("select * from producto")
    List<Producto> findAll();


}
