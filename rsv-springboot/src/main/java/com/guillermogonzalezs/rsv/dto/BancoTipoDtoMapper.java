package com.guillermogonzalezs.rsv.dto;

import com.guillermogonzalezs.rsv.models.entity.BancoTipoMovimiento;
import org.springframework.stereotype.Component;
import com.google.common.collect.Lists;


import java.util.List;

@Component
public class BancoTipoDtoMapper {

    public BancoTipoMovimientoDto toDTO(BancoTipoMovimiento c) {
        return new BancoTipoMovimientoDto(c);
    }

    public BancoTipoMovimiento toObject(BancoTipoMovimientoDto dto) {
        if (dto == null) {
            return null;
        }

        BancoTipoMovimiento bancoTipoMovimiento = new BancoTipoMovimiento();

        bancoTipoMovimiento.setId(dto.getId());
        bancoTipoMovimiento.setActivo(dto.getActivo());
        bancoTipoMovimiento.setGastoIngreso(dto.getGastoIngreso());
        bancoTipoMovimiento.setNombre(dto.getNombre());
        bancoTipoMovimiento.setImputableInmueble(dto.getImputableInmueble());

        return bancoTipoMovimiento;
    }

    public List<BancoTipoMovimientoDto> toDTOs(List<BancoTipoMovimiento> bancoTipoMovimientos) {
        List<BancoTipoMovimientoDto> retorno = Lists.newArrayList();

        if (bancoTipoMovimientos != null) {
            for (BancoTipoMovimiento bancoTipoMovimiento : bancoTipoMovimientos) {
                retorno.add(new BancoTipoMovimientoDto(bancoTipoMovimiento));
            }
        }

        return retorno;
    }

    public List<BancoTipoMovimiento> toObjects(List<BancoTipoMovimientoDto> entities) {
        List<BancoTipoMovimiento> retorno = Lists.newArrayList();
        for (BancoTipoMovimientoDto v : entities) {
            retorno.add(toObject(v));
        }
        return retorno;
    }




}
