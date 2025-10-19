package com.guillermogonzalezs.rsv.facturaRecibida.application;




import com.guillermogonzalezs.rsv.facturaRecibida.domain.EstadoDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindEstadoService {
    @Autowired private EstadoDao estadoDao;

    public List<Estado> obtenerTodos() {
        return  estadoDao.findAll(); }
    public Estado obtenerPorId(Integer id) {
        return estadoDao.findById(id);
    }




}
    
