package com.guillermogonzalezs.rsv.models.dao;

import com.guillermogonzalezs.rsv.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

     Usuario findByUsername(String username);
}
