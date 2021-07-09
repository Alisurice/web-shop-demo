package com.demo.base.service;

import com.demo.mbg.mapper.PmsCabinetMapper;
import com.demo.mbg.model.PmsCabinet;
import com.demo.mbg.model.PmsCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
