package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application;


import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.MovimientoDao;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.mybatis.MovimientoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersistMovimientoService {

    @Autowired
    private MovimientoDao movimientoDao;


    public void actualizar(Movimiento movimiento) {
        this.movimientoDao.update(movimiento);
    }


}
