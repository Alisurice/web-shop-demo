package com.demo.base.service;

import com.demo.mbg.mapper.PmsCabinetMapper;
import com.demo.mbg.model.PmsCabinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Component
public class TestServer {
    @Resource
    private PmsCabinetMapper pmsCabinetMapper;

    public void testFind(int id){
        System.out.println("test:"+pmsCabinetMapper.selectByPrimaryKey(id));
    }

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Cacheable(value = "testCache", key = "'in'",unless = "#result==null")
    public String testRedis(String in) {
        redisTemplate.opsForValue().set("ha",in);
        System.out.println(redisTemplate.opsForValue().get("ha"));
        return (String) redisTemplate.opsForValue().get("ha");
    }



    @Transactional()
    public void insertCharge(boolean isTryRollBack) {
        PmsCabinet pmsCabinet = new PmsCabinet();
        pmsCabinet.setMaxCharge(10);
        pmsCabinet.setPosition("test transaction");
        pmsCabinetMapper.insert(pmsCabinet);
        if(isTryRollBack== true){
            int i = 1 / 0;
        }
        System.out.println("if success you will see:id:"+pmsCabinet.getId());


    }
}
