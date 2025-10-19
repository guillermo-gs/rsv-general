package com.guillermogonzalezs.rsv.banco.tipoMovimiento.application;


import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimiento;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimientoRepository;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure.mybatis.TipoMovimientoMybatis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindTipoMovimientoService {
    private TipoMovimientoRepository repository;




    private TipoMovimientoMybatis mapper;
    public FindTipoMovimientoService(TipoMovimientoMybatis mapper) {
        this.mapper = mapper;
    }

    public List<TipoMovimiento> obtenerTodos() {
        return  mapper.findAll();
    }



}
