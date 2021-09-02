package com.demo.base.example.redis.service;

import com.demo.mbg.model.TRedPacket;

public interface RedPackService {
    /**
     * 获取红包
     * @param id
     * @return 红包信息
     */
    TRedPacket getRedPacket(Integer id);

    /**
     * 扣减红包
     * @param id
     * @return
     */
    int decreaseRedPacket(Integer id);

}
