package com.demo.base.example.rabbitmq.annotation.competition;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WorkRabbitConfig {

    @Bean
    public WorkSender workSender(){
        return new WorkSender();
    }

    @Bean
    public WorkReceiver workReceiver1(){
        return new WorkReceiver(1);
    }

    @Bean
    public WorkReceiver workReceiver2(){
        return new WorkReceiver(2);
    }

    @Bean
    public Queue workQueue(){
        return new Queue("work.hello");
    }


}
