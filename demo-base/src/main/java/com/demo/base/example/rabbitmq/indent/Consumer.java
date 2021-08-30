package com.demo.base.example.rabbitmq.indent;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        final Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        //完成exchange和queue的绑定，并为这个queue指定了交换机以及路由地址routingKey？、
        // 这才完成了消息队列的初始化。
        //声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "hola";
        //绑定队列，通过键 hola 将队列和交换器绑定起来
        channel.queueBind(queueName,exchangeName,routingKey);

        //消费消息
        while (true){
            boolean autoAck = false;
            String consumerTag = "";
            //建立监听器，DefaultConsumer就是监听到消息时候的处理函数、回调函数
            /**
             * 启动一个消费者，并返回服务端生成的消费者标识
             * queue:队列名
             * autoAck：true 接收到传递过来的消息后acknowledged（应答服务器），false 接收到消息后不应答服务器
             * consumerTag: 客户端生成的用于建立上线文的使用者标识,可以做此会话的名字
             * callback：消费者对象接口
             * @return 与消费者关联的消费者标识
             */
            channel.basicConsume(queueName,autoAck,consumerTag,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException{
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    System.out.println("消费的路由键：" + routingKey);
                    System.out.println("消费的内容类型：" + contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    //确认消息（如果想要拒收信息，要使用basicReject(long deliveryTag, boolean requeue)）
                    //basicAck(long deliveryTag, boolean multiple)
                    //deliveryTag：该消息的index，multiple：是否批量. true：将一次性ack所有小于deliveryTag的消息。
                    channel.basicAck(deliveryTag, false);
                    System.out.println("消费的消息体内容：");
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println(bodyStr);
                }
            });
        }





    }
}
