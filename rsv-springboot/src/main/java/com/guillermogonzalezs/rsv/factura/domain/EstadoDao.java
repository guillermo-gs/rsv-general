package com.guillermogonzalezs.rsv.factura.domain;

import com.guillermogonzalezs.rsv.factura.domain.entities.Estado;
import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;

import java.util.List;

public interface EstadoDao {
    Integer getId();
    void create(Estado factura);
    void update(Estado  factura);
    void delete(Integer id);
    List<Estado> findAll();
    Estado findById(Integer idFactura);

}