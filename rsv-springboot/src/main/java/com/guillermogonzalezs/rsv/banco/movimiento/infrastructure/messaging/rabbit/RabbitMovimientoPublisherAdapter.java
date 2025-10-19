package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.messaging.rabbit;

import com.guillermogonzalezs.rsv.banco.movimiento.domain.Movimiento;
import com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.application.port.out.MovimientoPublisherPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component("rabbitMovimientoPublisherAdapter")
public class RabbitMovimientoPublisherAdapter implements MovimientoPublisherPort {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMovimientoPublisherAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishCreated(Movimiento movimiento) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                movimiento
        );
    }
}