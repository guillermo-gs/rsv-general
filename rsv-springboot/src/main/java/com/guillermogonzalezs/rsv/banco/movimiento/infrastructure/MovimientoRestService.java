package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure;

import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.FindMovimientoService;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.PersistMovimientoService;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoRestService {

    @Autowired
    private FindMovimientoService findService;

    @Autowired
    private PersistMovimientoService persistService;


    public List<Movimiento> obtenerPorContrato(Integer idContrato) {
        return  findService.obtenerPorContrato(idContrato);
    }

    public List<Movimiento> obtenerTodos() {
        return  findService.obtenerTodos();
    }
    public Movimiento actualizar(Movimiento movimiento) {
        this.persistService.actualizar(movimiento);
        return findService.obtenerPorId(movimiento.getId());
    }


}
