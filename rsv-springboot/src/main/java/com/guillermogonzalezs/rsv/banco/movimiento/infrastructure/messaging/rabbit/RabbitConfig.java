package com.guillermogonzalezs.rsv.banco.movimiento.infrastructure.messaging.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE = "movimientos.exchange";
    public static final String QUEUE = "movimientos.queue";
    public static final String ROUTING_KEY = "movimientos.creados";

    @Bean
    public DirectExchange movimientosExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue movimientosQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding movimientosBinding() {
        return BindingBuilder.bind(movimientosQueue()).to(movimientosExchange()).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf, Jackson2JsonMessageConverter conv) {
        RabbitTemplate rt = new RabbitTemplate(cf);
        rt.setMessageConverter(conv);
        return rt;
    }
}