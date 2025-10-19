package com.guillermogonzalezs.rsv.contrato.infrastructure.myBatis;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.contrato.domain.ContratoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoRepositoryDaoImp implements ContratoDao {

    @Autowired
    ContratoMybatisRepository repository;

    @Autowired private ContratoDao contratoDao;


    @Override
    public Contrato findById(Integer idContrato) {
        return this.contratoDao.findById(idContrato);
    }

    @Override
    public List<Contrato> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Contrato> findActivos() {
        return this.contratoDao.findActivos();
    }

    @Override
    public List<Movimiento> findMovimientos(Contrato contrato) {
        return this.repository.findMovimientosContrato(contrato);
    }



}