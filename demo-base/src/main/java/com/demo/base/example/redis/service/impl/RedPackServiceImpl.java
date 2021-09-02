package com.demo.base.example.redis.service.impl;

import com.demo.base.example.redis.dao.RedPackDao;
import com.demo.base.example.redis.service.RedPackService;
import com.demo.mbg.mapper.TRedPacketMapper;
import com.demo.mbg.model.TRedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedPackServiceImpl implements RedPackService {
    @Autowired
    private RedPackDao redPackDao = null;
    @Autowired
    private TRedPacketMapper tRedPacketMapper = null;


    @Override
    public TRedPacket getRedPacket(Integer id) {
        return tRedPacketMapper.selectByPrimaryKey(id);
    }

    @Override
    public int decreaseRedPacket(Integer id) {
        return redPackDao.decreaseRedPack(id);
    }


}
