package com.guillermogonzalezs.rsv.facturaRecibida.domain;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Accion;


import java.util.List;

public interface AccionDao {
    List<Accion> findAll();
    List<Accion> findActivas();
    Accion findById(Integer idAccion);

}