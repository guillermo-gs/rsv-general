package com.guillermogonzalezs.rsv.contrato.application;



import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.contrato.infrastructure.myBatis.ContratoMybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class FindContratoService {
    @Autowired
    private ContratoMybatisRepository mapper;

    public List<Contrato> obtenerTodos() {
        return mapper.findAll();
    }

    public List<Contrato> obtenerSinFactura(LocalDate fechaIni, LocalDate fechaFin) {
        return mapper.findSinFactura(fechaIni, fechaFin);
    }

    public Contrato obtenerPorId(Integer idContrato) {
        return this.mapper.findById(idContrato);

    }




}
    
