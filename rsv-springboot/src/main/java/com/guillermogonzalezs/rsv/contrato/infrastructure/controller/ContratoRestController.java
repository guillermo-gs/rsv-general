package com.guillermogonzalezs.rsv.contrato.infrastructure.controller;


import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.MovimientoRestService;
import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import com.guillermogonzalezs.rsv.contrato.infrastructure.ContratoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrato")
public class ContratoRestController {

    @Autowired
    private ContratoRestService service;

    @Autowired
    private MovimientoRestService movimientoService;

    @GetMapping("")
    public List<Contrato> obtenerActivos() {
        return service.obtenerTodos();
    }

    @PostMapping(value = "/crear")
    public Contrato crear(@RequestBody Contrato obj){
        service.crear(obj);
        return obj;
    }


    @RequestMapping(value = {"sin-factura/{anno}/{mes}" }, method = RequestMethod.GET)
    public List<Contrato> obtenerSinFactura(@PathVariable Integer anno, @PathVariable Integer mes) {
        return  service.obtenerSinFactura(anno, mes);
    }

    @RequestMapping(value = {"obtener-movimientos/{idContrato}" }, method = RequestMethod.GET)
    public List<Movimiento> obtenerMovimientos(@PathVariable Integer idContrato) {
        return  movimientoService.obtenerPorContrato(idContrato);
    }


}