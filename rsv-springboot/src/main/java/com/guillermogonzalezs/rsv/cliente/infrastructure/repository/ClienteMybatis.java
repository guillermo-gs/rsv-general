package com.guillermogonzalezs.rsv.cliente.infrastructure.repository;

import com.guillermogonzalezs.rsv.cliente.domain.entities.Cliente;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClienteMybatis {
    Integer getId();
    List<Cliente> findAll();
    Cliente findById(Integer id);
    void update(@Param("cli") Cliente cliente);
    void create(@Param("cli") Cliente cliente);
    void delete(@Param("id") Integer id);


}