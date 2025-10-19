package com.guillermogonzalezs.rsv.models.services;

import com.guillermogonzalezs.rsv.models.dao.IUsuarioDao;
import com.guillermogonzalezs.rsv.models.entity.Role;
import com.guillermogonzalezs.rsv.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService" )
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioDao usuarioDao;

    private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =  usuarioDao.findByUsername(username);
        if (usuario == null) {
            logger.error("Error en login. Usuario2 " + username + " no existe");
            throw new UsernameNotFoundException("Error en login. Usuario " + username + " no existe");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role: usuario.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }
}
