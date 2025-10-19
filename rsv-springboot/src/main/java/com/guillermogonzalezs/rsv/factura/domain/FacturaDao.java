package com.guillermogonzalezs.rsv.factura.domain;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface FacturaDao {
    List<Factura> findAll();
    Factura findById(Integer idFactura);
    List<Item> findItemsByFacturaId(Integer idFactura);
    void grabarFactura(Integer contratoId, Integer serieId, Date fecha);

}