package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.FacturaRecibidaDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis.FacturaRecibidaMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaRecibidaDaoImp implements FacturaRecibidaDao {

    @Autowired
    FacturaRecibidaMybatis repository;

    @Autowired private FacturaRecibidaDao facturaRecibidaDao;


    @Override
    public FacturaRecibida findById(Integer idFacturaRecibida) {
       return  this.repository.findById(idFacturaRecibida);
    }

    @Override
    public FacturaRecibida findByUUID(String UUID) {
        return  this.repository.findByUUID(UUID);
    }

    @Override
    public List<FacturaRecibida> findAll() {
        return repository.findAll();
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void  create(FacturaRecibida facturaRecibida) {
        repository.create(facturaRecibida);
    }


    @Override
    public void updateSinFichero(FacturaRecibida facturaRecibida) {
        repository.updateSinFichero(facturaRecibida);
    }

    @Override
    public void updateConFichero(FacturaRecibida facturaRecibida) {
        repository.updateConFichero(facturaRecibida);

    }

    @Override
    public void delete(Integer id) {

        repository.delete(id);
    }

}