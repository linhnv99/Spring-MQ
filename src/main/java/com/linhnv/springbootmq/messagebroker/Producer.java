
package com.linhnv.springbootmq.messagebroker;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("producer")
public class Producer implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        sendMessage("all", 1000, "FOO_SERVICE");
        sendMessage("all", 1000, "BAR_SERVICE");
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String routingKey, int number, String service) {
        new Thread(() -> {
            for (int i = 1; i < number; i++) {
                sleep();
                String message = String.format("Message from [%s] = %d", service, i);
                rabbitTemplate.convertAndSend(routingKey, message);
                System.out.println(message);
            }
        }, service).start();
    }
}
