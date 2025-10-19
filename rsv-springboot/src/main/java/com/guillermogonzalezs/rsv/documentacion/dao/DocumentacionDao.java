package com.guillermogonzalezs.rsv.documentacion.dao;


import com.guillermogonzalezs.rsv.documentacion.entity.Documentacion;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipoRel;

import java.util.List;

public interface DocumentacionDao {
    List<Documentacion> findAll();
    List<DocumentacionTipo> findTipos();
    void  create(Documentacion documento);
    Documentacion  obtenerPorUUID(String uuid);
    void relacionarTipo(DocumentacionTipoRel relacion);
}