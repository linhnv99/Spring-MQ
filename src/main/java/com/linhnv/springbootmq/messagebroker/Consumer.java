package com.linhnv.springbootmq.messagebroker;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("consumer")
public class Consumer {

    @RabbitListener(queues = {"foo"})
    public void receive(Message message) {
        System.out.println("[X] Received " + message);
    }
}
