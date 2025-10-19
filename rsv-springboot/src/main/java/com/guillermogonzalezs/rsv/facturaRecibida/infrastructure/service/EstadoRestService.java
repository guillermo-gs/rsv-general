package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service;

import com.guillermogonzalezs.rsv.facturaRecibida.application.FindAccionService;
import com.guillermogonzalezs.rsv.facturaRecibida.application.FindEstadoService;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoRestService {

    @Autowired
    private FindEstadoService service;

    public List<Estado> obtenerTodos() {
        return service.obtenerTodos();
    }



}