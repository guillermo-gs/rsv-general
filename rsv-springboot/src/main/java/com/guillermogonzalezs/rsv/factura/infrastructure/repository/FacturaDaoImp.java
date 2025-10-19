package com.guillermogonzalezs.rsv.factura.infrastructure.repository;

import com.guillermogonzalezs.rsv.factura.domain.FacturaDao;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaDaoImp implements FacturaDao {

    @Autowired
    FacturaMybatis repository;

    @Autowired private FacturaDao facturaDao;


    @Override
    public Factura findById(Integer idFactura) {
        return this.facturaDao.findById(idFactura);
    }

    @Override
    public List<Item> findItemsByFacturaId(Integer idFactura) {
        return this.facturaDao.findItemsByFacturaId(idFactura);
    }

    @Override
    public void grabarFactura(Integer contratoId, Integer serieId, Date fecha) {

    }

    @Override
    public List<Factura> findAll() {
        return repository.findAll();
    }




}