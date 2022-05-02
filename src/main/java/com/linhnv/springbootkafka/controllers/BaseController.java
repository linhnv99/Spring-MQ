package com.linhnv.springbootkafka.controllers;

import com.linhnv.springbootkafka.kafka.MessageProducer;
import com.linhnv.springbootkafka.message.Action;
import com.linhnv.springbootkafka.message.BaseMessage;
import com.linhnv.springbootkafka.message.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/push")
    public void pushMessage() {
        BaseMessage<User> message = new BaseMessage<>();
        message.setAction(Action.valueOf("REQUEST_CREATE_USER"));
        message.setData(User.builder().id(1).name("Linh").build());
        messageProducer.sendMessage(message);
    }
}
