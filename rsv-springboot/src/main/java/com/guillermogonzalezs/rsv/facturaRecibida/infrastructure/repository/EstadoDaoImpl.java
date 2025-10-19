package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.AccionDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.EstadoDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.AccionMybatis;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.EstadoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoDaoImpl implements EstadoDao {

    @Autowired
    EstadoMybatis mapper;

    @Override
    public List<Estado> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Estado> findActivos() {
        return null;
    }

    @Override
    public Estado findById(Integer idAccion) {
        return null;
    }
}