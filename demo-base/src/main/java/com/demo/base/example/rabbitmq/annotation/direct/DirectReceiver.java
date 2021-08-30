package com.demo.base.example.rabbitmq.annotation.direct;

import cn.hutool.core.thread.ThreadUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.io.IOException;

public class DirectReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectReceiver.class);
    @Autowired
    RabbitTemplate rabbitTemplate;
    @RabbitListener(queues = "#{directQueue1.name}")
    public void receive1(String in){
        receive(in,1);
    }

    @RabbitListener(queues = "#{directQueue2.name}")
    public void receive2(String in){
        receive(in, 2);
    }

    @RabbitListener(queues = "#{directQueue2.name}")
    @RabbitHandler
    public void messageHandler(String body, Message message, Channel channel){
        try {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive(String in, int receiver){
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [x] Received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        LOGGER.info("instance {} [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in){
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
