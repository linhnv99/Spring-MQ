package com.linhnv.springbootkafka.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linhnv.springbootkafka.message.BaseMessage;
import com.linhnv.springbootkafka.message.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void listenMessage(String message) throws JsonProcessingException {
        System.out.println("Received Message: " + message);
        ObjectMapper mapper = new ObjectMapper();
        BaseMessage<User> base = mapper.readValue(message, BaseMessage.class);
        System.out.println(base.getAction());
    }

}
