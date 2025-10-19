package com.guillermogonzalezs.rsv.documentacion.dao;

import com.guillermogonzalezs.rsv.documentacion.dao.mybatis.DocumentacionMybatis;
import com.guillermogonzalezs.rsv.documentacion.entity.Documentacion;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipoRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentacionDaoImp implements DocumentacionDao {

    @Autowired
    DocumentacionMybatis repository;

    @Autowired private DocumentacionDao documentacionDao;


    @Override
    public List<Documentacion> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DocumentacionTipo> findTipos() {
        return repository.findTipos();
    }

    @Override
    public void  create(Documentacion documento) {
        repository.create(documento);
        // repository.createRelationDocument(documento);
    }

    @Override
    public Documentacion obtenerPorUUID(String uuid) {
        return repository.findByUUID(uuid);
    }

    @Override
    public void relacionarTipo(DocumentacionTipoRel relacion) {
        repository.relacionarTipo(relacion);
    }
}