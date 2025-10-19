package com.guillermogonzalezs.rsv.factura.infrastructure.repository;

import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaEstado;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacturaEstadoMybatis {

    List<FacturaEstado> findAll();


}