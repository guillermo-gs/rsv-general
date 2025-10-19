package com.guillermogonzalezs.rsv.factura.infrastructure.rest;

import com.guillermogonzalezs.rsv.factura.application.FindFacturaSerieService;
import com.guillermogonzalezs.rsv.factura.application.PersistFacturaService;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.FacturaSerie;
import com.guillermogonzalezs.rsv.factura.infrastructure.service.FacturaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/factura/factura-serie")
public class FacturaSerieRestController {


    @Autowired
    private FindFacturaSerieService findService;


    @RequestMapping(value = {"" }, method = RequestMethod.GET)
    public List<FacturaSerie> obtenerTodos() {
        return findService.obtenerTodos();
    }


}
