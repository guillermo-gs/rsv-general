package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application;


import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.MovimientoDao;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.mybatis.MovimientoMybatis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMovimientoService {


    private MovimientoMybatis mapper;
    public FindMovimientoService(MovimientoMybatis mapper) {
        this.mapper = mapper;
    }
    public List<Movimiento> obtenerTodos() {
        return  mapper.findAll();
    }
    public List<Movimiento> obtenerPorContrato(Integer idContrato) {
        return  mapper.findByContrato(idContrato);
    }
    public Movimiento obtenerPorId(Integer id) {
        return  mapper.findById(id);
    }





}
