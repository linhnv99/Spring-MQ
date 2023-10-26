package com.linhnv.springbootmq.messagebroker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("consumer")
public class Consumer {

    @RabbitListener(queues = {"foo", "bar"})
    public void receive(String message) {
        System.out.println("[X] Received: " + message);
    }

    @RabbitListener(queues = {"all"})
    public void receiveAll(String message) {
        System.out.println("[X][ALL] Received: " + message);
    }
}
