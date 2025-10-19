package com.guillermogonzalezs.rsv.movimientosBanco.model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final ReglaLoader reglaLoader;

    public void procesarMovimiento(Movimiento movimiento) {
        System.out.println("✅ Procesando movimiento en el servicio...");

        Map<String, Object> mapeado = mapear(movimiento.getDetalle());

        if (mapeado.containsKey("tipoMovimientoId")) {
            movimiento.setTipoMovimientoId((Integer) mapeado.get("tipoMovimientoId"));
        }

        System.out.println(mapeado);
    }

    public Map<String, Object> mapear(String descripcion) {
        Map<String, Object> resultado = new HashMap<>();
        if (descripcion == null || descripcion.isBlank()) return resultado;

        String texto = descripcion.toUpperCase();

        // ahora recorremos la lista de tipos desde la DB
        List<MovimientoTipo> reglas = reglaLoader.getReglas();

        for (MovimientoTipo tipo : reglas) {
            String nombre = tipo.getNombre() != null ? tipo.getNombre().toUpperCase() : "";

            if (texto.contains(nombre)) {
                resultado.put("tipoMovimientoId", tipo.getId());
                resultado.put("nombre", tipo.getNombre());
                resultado.put("gastoIngreso", tipo.getGastoIngreso());
                resultado.put("imputableContrato", tipo.getImputableContrato());
                resultado.put("imputableInmueble", tipo.getImputableInmueble());
                break; // dejamos de buscar en cuanto encontramos una coincidencia
            }
        }

        return resultado;
    }
}
