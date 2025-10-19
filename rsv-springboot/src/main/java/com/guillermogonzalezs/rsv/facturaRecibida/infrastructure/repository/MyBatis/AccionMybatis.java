package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccionMybatis {
    List<Accion> findAll();
    List<Accion> findActivas();
    Accion findById(@Param("id") Integer id);


}