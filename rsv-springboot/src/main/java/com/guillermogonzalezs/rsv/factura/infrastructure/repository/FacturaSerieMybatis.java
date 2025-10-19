package com.guillermogonzalezs.rsv.factura.infrastructure.repository;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FacturaSerieMybatis {

    List<FacturaSerie> findAll();


}