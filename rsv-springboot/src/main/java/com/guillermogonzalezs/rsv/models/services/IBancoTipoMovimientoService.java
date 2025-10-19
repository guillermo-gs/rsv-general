package com.guillermogonzalezs.rsv.models.services;

import com.guillermogonzalezs.rsv.dto.BancoTipoMovimientoDto;
import com.guillermogonzalezs.rsv.models.entity.BancoTipoMovimiento;

import java.util.List;

public interface IBancoTipoMovimientoService {

    public List<BancoTipoMovimientoDto> findAll();

    public void save(BancoTipoMovimiento bancoTipoMovimiento);

    public BancoTipoMovimiento findOne(Long id);

    public void delete(Long id);

}
