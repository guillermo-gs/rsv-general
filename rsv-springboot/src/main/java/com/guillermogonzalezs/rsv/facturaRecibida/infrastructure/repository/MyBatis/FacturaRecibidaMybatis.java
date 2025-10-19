package com.guillermogonzalezs.rsv.facturaRecibida.infrastructure.repository.MyBatis;

import com.guillermogonzalezs.rsv.facturaRecibida.domain.entities.FacturaRecibida;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FacturaRecibidaMybatis {
    List<FacturaRecibida> findAll();
    FacturaRecibida findById(@Param("id") Integer id);
    FacturaRecibida findByUUID(@Param("UUID") String UUID);
    void updateSinFichero(@Param("factura") FacturaRecibida facturaRecibida);
    void updateConFichero(@Param("factura") FacturaRecibida facturaRecibida);
    void create(@Param("factura") FacturaRecibida facturaRecibida);
    void delete(@Param("id") Integer id);


}