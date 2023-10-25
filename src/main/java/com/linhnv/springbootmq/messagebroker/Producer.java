package com.linhnv.springbootmq.messagebroker;

import org.springframework.amqp.core.Message;
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
        for (int i = 0; i < 1000; i++) {
            sleep();
            String message = "Message " + System.currentTimeMillis();
            rabbitTemplate.send("foo", new Message(message.getBytes()));
            System.out.println("Send message to queue " + message);
        }
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
