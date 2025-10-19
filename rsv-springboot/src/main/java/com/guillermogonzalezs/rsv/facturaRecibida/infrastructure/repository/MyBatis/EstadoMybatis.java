package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EstadoMybatis {
    List<Estado> findAll();
    List<Estado> findActivos();
    Estado findById(@Param("id") Integer id);


}