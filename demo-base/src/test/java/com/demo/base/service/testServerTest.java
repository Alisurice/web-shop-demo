package com.demo.base.service;

import com.demo.base.config.springConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

class testServerTest {

    @Resource
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
}