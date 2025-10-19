package com.guillermogonzalezs.rsv.documentacion.dao.mybatis;

import com.guillermogonzalezs.rsv.documentacion.entity.Documentacion;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipo;
import com.guillermogonzalezs.rsv.documentacion.entity.DocumentacionTipoRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocumentacionMybatis {
    List<Documentacion> findAll();
    List<DocumentacionTipo> findTipos();
    void create(@Param("documento") Documentacion documento);
    Documentacion findByUUID(@Param("uuid") String uuid);
    void relacionarTipo(@Param("relacion") DocumentacionTipoRel relacion);
   }