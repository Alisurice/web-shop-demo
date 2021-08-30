package com.demo.base.example.rabbitmq.indent;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置 RabbitMQ 地址
        factory.setHost("localhost");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        Channel channel = conn.createChannel();
        //声明交换器
        //exchange：交换机名称
        String exchangeName = "hello-exchange";
        //exchange：交换机名称, type：交换机类型, durable：设置是否持久化
        channel.exchangeDeclare(exchangeName,"direct", true);

        String routingKey = "hola";

        //exchange交换机和queue，以及路由地址routingKey的绑定写在了Consumer
        //因此，要先启动Consumer
        //发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
        channel.close();
        conn.close();
    }
}
