package com.guillermogonzalezs.rsv.controllers;


import com.guillermogonzalezs.rsv.mapper.ProductoMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/ejemplo")
public class EjemplosRestController {



    private ProductoMapper productoMapper;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("/usuarioinyectado")
    public String index(Authentication authentication) {
        if (authentication != null) {
            String texto = "Hola " +  authentication.getName();

            if (this.hasRole("ROLE_ADMIN")) {
                texto = texto + " Tienes el role ADMIN.";
            }
            if (this.hasRole("ROLE_USER")) {
                texto = texto + " Tienes el role USER.";
            }

            return  texto;
        }
        return "No se quien eres";
    }





    @PreAuthorize("hasAnyRole('ROLE_ADMIN'. 'ROLE_USER')")
    @GetMapping("/seguridad")
    public String seguridad(Authentication authentication, HttpServletRequest request) {
        if (authentication != null) {
            String texto = "Hola " + authentication.getName();
            SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "ROLE_");
            if (securityContext.isUserInRole("ADMIN")) {
                texto = texto + " Tienes el role ADMIN.";
            }

            if (securityContext.isUserInRole("USER")) {
                texto = texto + " Tienes el role USER.";
            }
            return texto;
        }
        return "No se quien eres";
    }

    @Secured("ROLE_USER")
    @GetMapping("/seguridadconrequesta")
    public String seguridadconrequest(Authentication authentication, HttpServletRequest request) {
        if (authentication != null) {
            logger.info("Hola " + authentication.getName()  );
            String texto = "Hola " + authentication.getName();
            if (request.isUserInRole("ROLE_ADMIN")) {
                logger.info("Hola " + authentication.getName()  );
                texto = texto + " Tienes el role ADMIN.";
            }

            if (request.isUserInRole("ROLE_USER")) {
                texto = texto + " Tienes el role USER.";
            }
            return texto;
        }
        return "No se quien eres";
    }


    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/usuarioestatico")
    public String admin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return "Hola " +  auth.getName();
        }
        return "No se quien eres";

    }


    private Boolean hasRole(String role) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }

        Authentication auth = context.getAuthentication();
        if (auth == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        return  authorities.contains(new SimpleGrantedAuthority(role));

    }

}
