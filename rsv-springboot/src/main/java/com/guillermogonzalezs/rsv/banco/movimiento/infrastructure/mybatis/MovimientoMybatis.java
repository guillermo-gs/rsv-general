package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.mybatis;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovimientoMybatis {

    List<Movimiento> findAll();
    List<Movimiento> findByContrato(@Param("idContrato") Integer idContrato);

    Movimiento findById(@Param("id") Integer id);
    void update(@Param("movimiento") Movimiento movimiento);
    void grabarLista(List<Movimiento> movimientos);
    void grabar(@Param("movimiento") Movimiento movimiento);



}
