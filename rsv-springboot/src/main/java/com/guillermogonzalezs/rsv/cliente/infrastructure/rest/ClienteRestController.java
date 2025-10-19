package com.guillermogonzalezs.rsv.cliente.infrastructure.rest;


import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.cliente.infrastructure.service.ClienteRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class ClienteRestController {

    @Autowired
    private ClienteRestService service;

    @GetMapping("")
    public List<Cliente> obtenerActivos() {
        return service.obtenerTodos();
    }

    @RequestMapping(value = {"obtener-por-id/{idCliente}" }, method = RequestMethod.GET)
    public Cliente obtenerPorId(@PathVariable Integer idCliente) {
        return  service.obtenerPorId(idCliente);
    }



    @PostMapping(value = "/crear")
    public Cliente crear( @RequestBody Cliente obj){
        service.crear(obj);
        return obj;
    }

    @PutMapping("/modificar/{idPersona}")
    public Cliente actualizar(@PathVariable Integer idPersona, @RequestBody Cliente cliente){
        cliente.setId(idPersona);
         service.actualizar(cliente);
        return service.obtenerPorId(cliente.getId());
    }


}