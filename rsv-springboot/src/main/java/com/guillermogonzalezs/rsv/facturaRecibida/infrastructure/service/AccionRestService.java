package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service;

import com.guillermogonzalezs.rsv.facturaRecibida.application.FindAccionService;
import com.guillermogonzalezs.rsv.facturaRecibida.application.FindFacturaRecibidaService;
import com.guillermogonzalezs.rsv.facturaRecibida.application.PersistFacturaRecibidaService;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.AccionDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.FacturaRecibidaDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.AccionDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccionRestService {

    @Autowired
    private FindAccionService service;

    public List<Accion> obtenerTodos() {
        return service.obtenerTodos();
    }



}