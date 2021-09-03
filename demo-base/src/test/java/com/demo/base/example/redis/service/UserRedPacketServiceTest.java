package com.demo.base.example.redis.service;

import com.demo.base.example.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("seckill")
public class UserRedPacketServiceTest {
    @Autowired
    UserRedPacketService userRedPacketService = null;
    @Autowired
    RedisTemplate redisTemplate;

    @Value("${test}")
    private String test;

    final int packet = 1;
    @Test
    public void TestGrapRedPacket(){
        //初始化,对应lua脚本的stock
        redisTemplate.opsForHash().put("red_packet_"+packet, "stock",2000);
        //对应UserRedPacketServiceImpl。unitAmountStr
        redisTemplate.opsForHash().put("red_packet_"+packet, "unit_amount",1);
        System.out.println("######"+redisTemplate.opsForHash().get("red_packet_"+packet, "stock"));
        System.out.println("######"+test);

        LocalDateTime start = LocalDateTime.now();

        //只运行一次来测试redis，因为只运行了一次，所以不会触发resut==2，从而修改数据库
        //userRedPacketService.grabRedPacket(packet, 1);

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println("operation ok");
        System.out.println("开始时间："+start);
        System.out.println("结束时间"+end);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            System.out.println("持久化结束，主线程收到InterruptedException"+LocalDateTime.now());
            //e.printStackTrace();
        }


    }
}