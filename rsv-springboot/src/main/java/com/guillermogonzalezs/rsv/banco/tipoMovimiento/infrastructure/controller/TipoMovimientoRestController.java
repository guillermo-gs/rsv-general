package com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure.controller;



import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimiento;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure.TipoMovimientoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banco")
public class TipoMovimientoRestController {

    @Autowired
    TipoMovimientoRestService service;

                @GetMapping("tipo-movimiento")
    public List<TipoMovimiento> queryAll() {
        return service.obtenerTodos();
        //return  mapper.findAll();
    }

}
