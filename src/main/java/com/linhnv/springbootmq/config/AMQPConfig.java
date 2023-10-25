package com.linhnv.springbootmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    /*
        Exchange: Sử dụng loại exchange nào:  topic, direct, fanout, dead, headers
        Queue: Định nghĩa các queue để nhận message
        Binding: map giữa producer và queue dựa vào routing pattern

            routing pattern:
                * - chính xác 1 từ
                # - 1 or nhiều
     */

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic.exchange", true, false);
    }

    @Bean
    public Queue queue() {
        return new Queue("foo");
    }

    @Bean
    public Binding topicBinding(TopicExchange topicExchange, Queue queue) {
        return BindingBuilder.bind(queue)
                .to(topicExchange)
                .with("*.foo");
    }
}
