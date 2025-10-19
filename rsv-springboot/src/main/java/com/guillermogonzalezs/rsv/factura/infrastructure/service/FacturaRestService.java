package com.guillermogonzalezs.rsv.factura.infrastructure.service;

import com.guillermogonzalezs.rsv.factura.application.FindFacturaService;
import com.guillermogonzalezs.rsv.factura.application.PersistFacturaService;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.infrastructure.pdf.FacturaPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacturaRestService {
    @Autowired
    private PersistFacturaService persistFacturaService;

    @Autowired
    private FindFacturaService service;

    @Autowired
    private FacturaPdf facturaPdf;


    public List<Factura> obtenerTodos() {
        return service.obtenerTodos();
    }
    public Factura obtenerPorId(Integer id) { return service.obtenerPorId(id); }
    public Factura obtenerPorUUID(String UUID) { return service.obtenerPorUUID(UUID); }

}