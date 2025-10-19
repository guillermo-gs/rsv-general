package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.service;

import com.guillermogonzalezs.rsv.facturaRecibida.application.FindFacturaRecibidaService;
import com.guillermogonzalezs.rsv.facturaRecibida.application.PersistFacturaRecibidaService;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.FacturaRecibidaDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaRecibidaRestService {




    @Autowired
    private FacturaRecibidaDaoImp facturaRecibidaDaoImpl;


    @Autowired
    private FindFacturaRecibidaService service;

    @Autowired
    private PersistFacturaRecibidaService persistService;


    public List<FacturaRecibida> obtenerTodos() {
        return service.obtenerTodos();
    }

    public FacturaRecibida obtenerPorId(Integer id) {
        return service.obtenerPorId(id);
    }

    public void crear(FacturaRecibida obj) {
        facturaRecibidaDaoImpl.create(obj);
    }

    public FacturaRecibida actualizarSinFichero(FacturaRecibida facturaRecibida) {
        this.facturaRecibidaDaoImpl.updateSinFichero(facturaRecibida);
        return  facturaRecibidaDaoImpl.findById(facturaRecibida.getId());
    }
    public FacturaRecibida actualizarConFichero(FacturaRecibida facturaRecibida) {
        this.facturaRecibidaDaoImpl.updateConFichero(facturaRecibida);
        return  facturaRecibidaDaoImpl.findById(facturaRecibida.getId());
    }

    public FacturaRecibida obtenerPorUUID(String UUID) {
        return  facturaRecibidaDaoImpl.findByUUID(UUID);
    }

}