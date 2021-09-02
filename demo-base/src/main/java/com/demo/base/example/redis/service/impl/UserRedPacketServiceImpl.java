package com.demo.base.example.redis.service.impl;

import com.demo.base.example.redis.dao.RedPackDao;
import com.demo.base.example.redis.service.UserRedPacketService;
import com.demo.mbg.mapper.TRedPacketMapper;
import com.demo.mbg.mapper.TUserRedPacketMapper;
import com.demo.mbg.model.TRedPacket;
import com.demo.mbg.model.TUserRedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    @Autowired
    TUserRedPacketMapper tUserRedPacketMapper;

    @Autowired
    TRedPacketMapper tRedPacketMapper;

    @Autowired
    RedPackDao redPackDao;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int grabRedPacket(Integer redPacketId, Integer userId) {
        TRedPacket tRedPacket = tRedPacketMapper.selectByPrimaryKey(redPacketId);
        //当前小红包库存大于零
        if(tRedPacket.getStock() > 0){
            redPackDao.decreaseRedPack(redPacketId);
            //生成抢红包信息
            TUserRedPacket tUserRedPacket = new TUserRedPacket();
            tUserRedPacket.setRedPacketId(redPacketId);
            tUserRedPacket.setUserId(userId);
            tUserRedPacket.setGrabTime(new Date());
            tUserRedPacket.setAmount(new BigDecimal(tRedPacket.getUnitAmount()));
            tUserRedPacket.setNote("抢红包"+redPacketId);

            //插入数据库
            return tUserRedPacketMapper.insert(tUserRedPacket);
        }
        return -1;
    }



}
