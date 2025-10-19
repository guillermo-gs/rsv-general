package com.guillermogonzalezs.rsv.contrato.infrastructure;

import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.FindMovimientoService;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import com.guillermogonzalezs.rsv.contrato.application.FindContratoService;
import com.guillermogonzalezs.rsv.contrato.application.PersistContratoService;
import com.guillermogonzalezs.rsv.contrato.domain.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContratoRestService {

    @Autowired
    private FindContratoService service;

    @Autowired
    private PersistContratoService persistService;

    @Autowired
    FindMovimientoService movimientoService;


    public List<Contrato> obtenerTodos() {
        return service.obtenerTodos();
    }
    public List<Contrato> obtenerActivos() {
        return service.obtenerTodos();
    }
    public List<Movimiento> obtenerMovimientos(Integer idContrato) {
        return movimientoService.obtenerPorContrato(idContrato);
    }

    public void crear(Contrato c) {
        Cliente cli = new Cliente();
        persistService.grabar(c, cli);

    }


    public List<Contrato> obtenerSinFactura(Integer anno, Integer mes) {

        LocalDate fini = LocalDate.of(anno, mes, 1);
        LocalDate ffin = fini.withDayOfMonth(fini.lengthOfMonth());
        return service.obtenerSinFactura(fini, ffin);




    }
}