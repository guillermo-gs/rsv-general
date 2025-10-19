package com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure;

import com.guillermogonzalezs.rsv.banco.tipoMovimiento.application.FindTipoMovimientoService;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMovimientoRestService {

    @Autowired
    FindTipoMovimientoService service;


    public List<TipoMovimiento> obtenerTodos() {
        return  service.obtenerTodos();
    }
}
