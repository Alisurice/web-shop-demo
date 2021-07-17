package com.demo.base.service;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Slf4j
public class TestMongodb {
    @Test
    public void testSomething(){
        ObjectId a = new ObjectId();
        Date d = new Date();
        log.info("getTime:"+ d.getTime());
        log.info(a.toString());
        log.info(String.valueOf(a.getTimestamp()));


    }
}
