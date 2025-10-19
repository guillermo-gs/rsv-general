package com.guillermogonzalezs.rsv.documentacion.service;


import com.guillermogonzalezs.rsv.documentacion.dao.DocumentacionDaoImp;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentacionTipoService {

    @Autowired
    private DocumentacionDaoImp mapper;

    public List<DocumentacionTipo> obtenerTodos() {
        return mapper.findTipos();
    }
}
    
