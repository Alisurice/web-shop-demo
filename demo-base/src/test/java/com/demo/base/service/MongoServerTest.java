package com.demo.base.service;

import com.demo.mbg.model.UmsGuest;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class MongoServerTest {

    private MongoServer mongoServer;
    @Autowired
    private TestMongoRepository testMongoRepository;

    @Autowired
    public MongoServerTest(MongoServer mongoServer){
        this.mongoServer = mongoServer;
    }

    @Test
    void findByImpl(){
        System.out.println(testMongoRepository.findUmsGuestById(12));
        System.out.println("find with query condition"+testMongoRepository.findById(12));
    }

    @Test
    void create() {
        UmsGuest umsGuest = new UmsGuest();
        umsGuest.setId(12);
        umsGuest.setPassword("hwehh");
        mongoServer.create(umsGuest);



    }
}