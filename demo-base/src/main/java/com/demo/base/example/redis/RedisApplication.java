package com.demo.base.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@Slf4j
@SpringBootApplication
@EnableCaching
@MapperScan({"com.demo.mbg.mapper","com.demo.base.dao","com.demo.base.example.redis.dao"})
public class RedisApplication {

    public static void main(String[] args)  {
        SpringApplication.run(RedisApplication.class, args);

    }



}
