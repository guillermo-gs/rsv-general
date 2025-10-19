package com.guillermogonzalezs.rsv.models.services;

import com.guillermogonzalezs.rsv.dto.BancoTipoDtoMapper;
import com.guillermogonzalezs.rsv.dto.BancoTipoMovimientoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.guillermogonzalezs.rsv.models.dao.IBancoTipoMovimientoDao;
import com.guillermogonzalezs.rsv.models.entity.BancoTipoMovimiento;

import java.util.List;

@Service
public class BancoTipoMovimientoServiceImpl implements  IBancoTipoMovimientoService {
    @Autowired
    private IBancoTipoMovimientoDao bancoTipoMovimientoDao;

    @Autowired
    BancoTipoDtoMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<BancoTipoMovimientoDto> findAll() {
        return  mapper.toDTOs((List<BancoTipoMovimiento>) bancoTipoMovimientoDao.findAll());
    }

    @Override
    @Transactional
    public void save(BancoTipoMovimiento bancoTipoMovimiento) {
        bancoTipoMovimientoDao.save(bancoTipoMovimiento);

    }

    @Override
    @Transactional(readOnly = true)
    public BancoTipoMovimiento findOne(Long id) {
        return bancoTipoMovimientoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bancoTipoMovimientoDao.deleteById(id);
    }
}
