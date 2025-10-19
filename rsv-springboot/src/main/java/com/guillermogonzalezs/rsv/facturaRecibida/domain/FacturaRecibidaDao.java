package com.guillermogonzalezs.rsv.facturaRecibida.domain;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;

import java.util.List;

public interface FacturaRecibidaDao {
    Integer getId();
    void create(FacturaRecibida facturaRecibida);
    void updateSinFichero(FacturaRecibida facturaRecibida);
    void updateConFichero(FacturaRecibida facturaRecibida);
    void delete(Integer id);
    List<FacturaRecibida> findAll();
    FacturaRecibida findById(Integer idFacturaRecibida);
    FacturaRecibida findByUUID(String UUID);

}