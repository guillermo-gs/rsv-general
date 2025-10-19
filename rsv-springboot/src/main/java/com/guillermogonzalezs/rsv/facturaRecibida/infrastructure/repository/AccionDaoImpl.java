package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.AccionDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.AccionMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionDaoImpl implements AccionDao {

    @Autowired
    AccionMybatis mapper;

    @Override
    public List<Accion> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Accion> findActivas() {
        return null;
    }

    @Override
    public Accion findById(Integer idAccion) {
        return null;
    }
}