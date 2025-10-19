package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.rest;


import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service.AccionRestService;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service.EstadoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/factura-recibida/estados")
public class EstadoFacturaRecibidaRestController {

    @Autowired
    private EstadoRestService service;

    @GetMapping("")
    public List<Estado> obtenerTodos() {
        return service.obtenerTodos();
    }


}