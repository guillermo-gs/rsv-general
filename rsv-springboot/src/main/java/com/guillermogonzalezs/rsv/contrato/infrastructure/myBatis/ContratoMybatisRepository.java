package com.guillermogonzalezs.rsv.contrato.infrastructure.myBatis;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.models.entity.BancoMovimiento;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface ContratoMybatisRepository {

    List<Contrato> findAll();
    List<Contrato> findSinFactura(@Param("fechaIni") LocalDate fechaIni, @Param("fechaFin") LocalDate fechaFin);
    Contrato findById(@Param("id") Integer id);
    List<Movimiento> findMovimientosContrato(@Param("contrato") Contrato contrato);
    void create(@Param("con") Contrato contrato, @Param("cli") Cliente cliente);


}