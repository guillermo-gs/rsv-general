package com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure.mybatis;

import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimiento;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TipoMovimientoMybatis {

    List<TipoMovimiento> findAll();



}
