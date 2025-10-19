package com.guillermogonzalezs.rsv.models.dao;

import com.guillermogonzalezs.rsv.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
