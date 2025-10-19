package com.guillermogonzalezs.rsv.factura.infrastructure.repository;

import com.guillermogonzalezs.rsv.factura.domain.entities.Factura;
import com.guillermogonzalezs.rsv.factura.domain.entities.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FacturaMybatis {
    Integer getId();
    List<Factura> findAll();
    Factura findById(Integer id);
    Factura findByUUID(String UUID);
    void update(@Param("factura") Factura factura);
    void updateById(@Param("factura") Factura factura);
    void create(@Param("fact") Factura factura);
    void delete(@Param("fact") Integer id);

    void  grabarPdf(@Param("factura") Factura factura, byte[] contenido);

    List<Item> findItemsByFacturaId(@Param("facturaId") Integer facturaId);

    void grabarFacturaAutomatica(@Param("factura") Factura factura );
    void grabarItemAutomatico(@Param("factura") Factura factura );

    Integer siguienteCodigo(@Param("serieId") Integer serieId);

}