package com.guillermogonzalezs.rsv.banco.movimiento.domain;

import java.util.List;

public interface MovimientoDao {
    List<Movimiento> findAll();
    Movimiento findById(Integer id);
    List<Movimiento> findByContrato(Integer idContrato);
    //void create(Movimiento movimiento);
    //void delete(Integer id);
    void update(Movimiento movimiento);
    List<Movimiento> grabarLista(List<Movimiento> movimientos);

}
