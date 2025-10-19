package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.controller;


import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.Cuaderno45Service;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.MovimientoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/banco/n45")
public class MovimientoRestController {
    private static String UPLOADED_FOLDER = "/out";
    @Autowired
    private  MovimientoRestService service;

    @Autowired
    private Cuaderno45Service cuaderno45Service;


    @GetMapping("")
    public List<Movimiento> queryAll() {
        return service.obtenerTodos();
    }



    @PutMapping("/modificar/{idMovimiento}")
    public Movimiento actualizar(@PathVariable int idMovimiento, @RequestBody Movimiento movimiento){
        return service.actualizar(movimiento);
    }


    @PostMapping("/upload") // //new annotation since 4.3
    public List<Movimiento> singleFileUpload(@RequestParam("fichero") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new Exception("Please select a file to upload");
        }
        return this.cuaderno45Service.procesarCuaderno(file);

    }


}
