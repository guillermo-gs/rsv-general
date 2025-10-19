package com.guillermogonzalezs.rsv.facturaRecibida.application;



import com.guillermogonzalezs.rsv.facturaRecibida.domain.AccionDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAccionService {
    @Autowired private AccionDao accionDao;

    public List<Accion> obtenerTodos() {
        return  accionDao.findAll(); }
    public Accion obtenerPorId(Integer id) {
        return accionDao.findById(id);
    }




}
    
