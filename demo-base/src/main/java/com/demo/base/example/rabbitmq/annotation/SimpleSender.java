package com.demo.base.example.rabbitmq.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class SimpleSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName = "simple.hello";

    public void send(){
        String message = "hello world";
        this.rabbitTemplate.convertAndSend(queueName,message);
    }
}
