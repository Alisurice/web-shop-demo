package com.demo.base.service;

import com.demo.base.config.springConfig;
import com.demo.mbg.model.UmsGuest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;



@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
//@ContextConfiguration(classes={springConfig.class})
class testServerTest {

    @Autowired
    private TestServer testServer;
    @Test
    void testFind() {
        if(testServer == null){
            System.out.println("null##############");
            return;
        }
        testServer.testFind(1);
    }


    @Test
    void insertCharge() {
        testServer.insertCharge(false);

    }

    //@Autowired
    //StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void testRedis() {
        //执行，然后修改in，应该会看到两次测试cacheable的返回值是一样的，提示cacheable生效
        String in = "hh";
        System.out.println("测试cacheable：输入："+in+" output:"+testServer.testRedis(in));
        redisTemplate.opsForValue().set("ha","w2");
        System.out.println(redisTemplate.opsForValue().get("ha"));
    }
}