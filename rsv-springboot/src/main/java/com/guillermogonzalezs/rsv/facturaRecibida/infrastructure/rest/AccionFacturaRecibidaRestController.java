package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.rest;


import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service.AccionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura-recibida/accion")
public class AccionFacturaRecibidaRestController {

    @Autowired
    private AccionRestService service;

    @GetMapping("")
    public List<Accion> obtenerTodos() {
        return service.obtenerTodos();
    }


}