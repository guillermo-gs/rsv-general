package com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure;

import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimiento;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.domain.TipoMovimientoRepository;
import com.guillermogonzalezs.rsv.banco.tipoMovimiento.infrastructure.mybatis.TipoMovimientoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMovimientoRepositoryImp implements TipoMovimientoRepository {
    @Autowired
    TipoMovimientoMybatis repositoru;


    @Override
    public List<TipoMovimiento> findAll() {
        return repositoru.findAll();
    }
}
