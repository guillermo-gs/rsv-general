package com.guillermogonzalezs.rsv.movimientosBanco.model;
import com.guillermogonzalezs.rsv.movimientosBanco.model.MovimientoTipo;
import com.guillermogonzalezs.rsv.movimientosBanco.model.MovimientoTipoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReglaLoader {

    private final MovimientoTipoRepository repo;

    private List<MovimientoTipo> reglas;

    @PostConstruct
    public void cargarReglas() {
        this.reglas = repo.findAll();
    }

    public List<MovimientoTipo> getReglas() {
        return reglas;
    }
}
