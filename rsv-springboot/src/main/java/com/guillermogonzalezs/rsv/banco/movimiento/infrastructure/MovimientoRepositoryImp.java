package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.domain.MovimientoDao;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.port.out.MovimientoPublisherPort;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.mybatis.MovimientoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import java.util.List;

@Service
public class MovimientoRepositoryImp implements MovimientoDao {
    @Autowired
    MovimientoMybatis repository;

    @Autowired
    private MovimientoPublisherPort publisher;


    @Override
    public List<Movimiento> findAll() {
        return repository.findAll();
    }


    @Override
    public Movimiento findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Movimiento> findByContrato(Integer idContrato) {
        return repository.findByContrato(idContrato);
    }

    @Override
    public void update(Movimiento movimiento) {
        repository.update(movimiento);

    }

    @Override
    public List<Movimiento> grabarLista(List<Movimiento> movimientos) {
        repository.grabarLista(movimientos);

        movimientos.forEach(publisher::publishCreated);

//        // Publicar SOLO si el commit llega a buen puerto
//        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
//            @Override
//            public void afterCommit() {
//                movimientos.forEach(publisher::publishCreated);
//                // Si prefieres batch:
//                // publisher.publishCreatedBatch(movimientos);
//            }
//        });

        return movimientos;
    }
}
