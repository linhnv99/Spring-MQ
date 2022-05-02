package com.linhnv.springbootkafka.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jpackage.internal.Log;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private final Logger logger = LogManager.getLogger(getClass());

    @Value("${kafka.bootstrap.server}")
    private String boostrapServer;

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<>(producerFactory());
//        kafkaTemplate.setProducerListener(new ProducerListener<String, Object>() {
//            @Override
//            public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
//
//                logger.info("ACK from ProducerListener message: {} offset:  {}",
//                        producerRecord.value(),
//                        recordMetadata.offset());
//                ProducerListener.super.onSuccess(producerRecord, recordMetadata);
//            }
//
//            @Override
//            public void onError(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata, Exception exception) {
//                ProducerListener.super.onError(producerRecord, recordMetadata, exception);
//            }
//        });
        return kafkaTemplate;
    }

}
