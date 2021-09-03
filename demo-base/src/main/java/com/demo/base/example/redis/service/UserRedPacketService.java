package com.demo.base.example.redis.service;

public interface UserRedPacketService {

    /**
     * 记录用户抢红包的信息
     * @param redPacketId 红包编号
     * @param userId 用户编号
     * @return
     */
    Long grabRedPacket(Integer redPacketId, Integer userId);
}
