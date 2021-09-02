package com.demo.base.example.redis.service;

import com.demo.base.example.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class UserRedPacketServiceTest {
    @Autowired
    UserRedPacketService userRedPacketService = null;
    final int packet = 1;
    @Test
    public void TestGrapRedPacket(){

        userRedPacketService.grabRedPacket(packet, 1);
        LocalDateTime start = LocalDateTime.now();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for(int count = 0; count < 4; count++){
            pool.execute(() -> {
                for (int i = 0; i < 600; i++) {
                    userRedPacketService.grabRedPacket(packet, i);
                    //System.out.println("result"+userRedPacketService.grabRedPacket(packet, i));

                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            LocalDateTime end = LocalDateTime.now();
            System.out.println("operation ok");
            System.out.println("开始时间："+start);
            System.out.println("结束时间"+end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}