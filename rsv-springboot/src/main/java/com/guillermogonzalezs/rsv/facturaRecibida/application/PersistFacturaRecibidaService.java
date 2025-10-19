package com.guillermogonzalezs.rsv.facturaRecibida.application;



import com.guillermogonzalezs.rsv.facturaRecibida.domain.FacturaRecibidaDao;
import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistFacturaRecibidaService {
    @Autowired private FacturaRecibidaDao facturaRecibidaDao;


    public void actualizarConFichero(FacturaRecibida facturaRecibida) {
        this.facturaRecibidaDao.updateConFichero(facturaRecibida);
    }
    public void actualizarSinFichero(FacturaRecibida facturaRecibida) {
        this.facturaRecibidaDao.updateSinFichero(facturaRecibida);
    }


}
