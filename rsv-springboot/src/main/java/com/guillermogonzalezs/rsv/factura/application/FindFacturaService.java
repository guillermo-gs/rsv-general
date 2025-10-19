package com.guillermogonzalezs.rsv.factura.application;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import com.guillermogonzalezs.rsv.factura.infrastructure.repository.FacturaMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindFacturaService {


    @Autowired
    private FacturaMybatis mapper;

    public List<Factura> obtenerTodos() {
        return mapper.findAll();
    }
    public Factura obtenerPorId(Integer idFactura) {
        return mapper.findById(idFactura);
    }
    public Factura obtenerPorUUID(String UUID) {
        return mapper.findByUUID(UUID);
    }

    public List<Item> obtenerItems(Integer idFactura) {
        return mapper.findItemsByFacturaId(idFactura);
    }

}
