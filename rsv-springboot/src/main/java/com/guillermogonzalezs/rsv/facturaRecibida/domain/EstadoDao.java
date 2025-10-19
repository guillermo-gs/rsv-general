package com.guillermogonzalezs.rsv.facturaRecibida.domain;


import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.Estado;

import java.util.List;

public interface EstadoDao {
    List<Estado> findAll();
    List<Estado> findActivos();
    Estado findById(Integer idAccion);

}