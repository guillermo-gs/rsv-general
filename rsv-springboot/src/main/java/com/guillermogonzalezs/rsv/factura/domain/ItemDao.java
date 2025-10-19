package com.guillermogonzalezs.rsv.factura.domain;

import com.guillermogonzalezs.rsv.factura.domain.entities.Estado;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;

import java.util.List;

public interface ItemDao {

    Item findById(Integer idFactura);
    List<Item> findByFacturaId(Integer idFactura);


}