package com.guillermogonzalezs.rsv.factura.infrastructure.rest;

import com.guillermogonzalezs.rsv.factura.application.FindFacturaEstadoService;
import com.guillermogonzalezs.rsv.factura.application.FindFacturaSerieService;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaEstado;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/factura/factura-estado")
public class FacturaEstadoRestController {


    @Autowired
    private FindFacturaEstadoService findService;


    @RequestMapping(value = {"" }, method = RequestMethod.GET)
    public List<FacturaEstado> obtenerTodos() {
        return findService.obtenerTodos();
    }


}
