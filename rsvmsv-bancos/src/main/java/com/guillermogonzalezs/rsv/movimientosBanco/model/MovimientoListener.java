package com.guillermogonzalezs.rsv.movimientosBanco.model;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MovimientoListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MovimientoService movimientoService;

    public MovimientoListener(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @RabbitListener(queues = "${app.queue.movimientos}"/*, ackMode = "AUTO"*/)
    public void recibirMensaje(String mensaje) {
        try {
            Movimiento movimiento = objectMapper.readValue(mensaje, Movimiento.class);
            movimientoService.procesarMovimiento(movimiento);


            System.out.println("📥 Movimiento recibido:");
            System.out.println("ID: " + movimiento.getId());
            System.out.println("Cuenta: " + movimiento.getCuenta());
            System.out.println("Importe: " + movimiento.getImporte());
            System.out.println("Debe/Haber: " + movimiento.getDebeHaber());
            System.out.println("Detalle: " + movimiento.getDetalle());
            System.out.println("----");
        } catch (Exception e) {
            System.err.println("❌ Error procesando mensaje: " + e.getMessage());
        }
    }
}