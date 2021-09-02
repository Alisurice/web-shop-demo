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
/**
 * 参考：https://blog.csdn.net/zzqtty/article/details/81741603
 * 高并发抢红包案列以及使用锁，版本号，redis缓存解决，项目可运行，详细注释(二)
 */
public class UserRedPacketServiceImpl implements UserRedPacketService {
    private static final int FAILED = 0;
    @Autowired
    TUserRedPacketMapper tUserRedPacketMapper;

    @Autowired
    TRedPacketMapper tRedPacketMapper;

    @Autowired
    RedPackDao redPackDao;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int grabRedPacket(Integer redPacketId, Integer userId) {
        //重入机制，重入3次。当还有库存的时候，就直接重入。
        //重入机制保证了在还有库存的时候进来的人，能够有较大可能获得库存，而不是因为version冲突了就放弃获取库存。
        //算是一种模拟先来先得的机制？
        for (int i = 0; i < 3; i++) {
            TRedPacket tRedPacket = tRedPacketMapper.selectByPrimaryKey(redPacketId);
            //当前小红包库存大于零
            if (tRedPacket.getStock() > 0) {
                int update = redPackDao.decreaseRedPacketForVersion(redPacketId, tRedPacket.getVersion());
                if (update == 0) {
                    continue;
                }
                //生成抢红包信息
                TUserRedPacket tUserRedPacket = new TUserRedPacket();
                tUserRedPacket.setRedPacketId(redPacketId);
                tUserRedPacket.setUserId(userId);
                tUserRedPacket.setGrabTime(new Date());
                tUserRedPacket.setAmount(new BigDecimal(tRedPacket.getUnitAmount()));
                tUserRedPacket.setNote("抢红包" + redPacketId);

                //插入数据库
                return tUserRedPacketMapper.insert(tUserRedPacket);
            }else{
                break;
            }
        }
        return FAILED;
    }



}
