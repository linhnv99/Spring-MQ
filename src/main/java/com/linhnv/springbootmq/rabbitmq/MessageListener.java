package com.linhnv.springbootmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class MessageListener {

    @RabbitListener(queues = "q1")
    public void receive1(String data) {
        System.out.println("---- Receive from q1 :" + data);
    }

    @RabbitListener(queues = "q2")
    public void receive2(String data) {
        System.out.println("---- Receive from q2 :" + data);
    }
}
