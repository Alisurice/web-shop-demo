package com.demo.base.example.redis.service.impl;

import com.demo.base.example.redis.dao.RedPackDao;
import com.demo.base.example.redis.service.RedisRedPacketService;
import com.demo.base.example.redis.service.UserRedPacketService;
import com.demo.mbg.mapper.TRedPacketMapper;
import com.demo.mbg.mapper.TUserRedPacketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
/**
 * 参考：https://blog.csdn.net/zzqtty/article/details/81741603
 * 高并发抢红包案列以及使用锁，版本号，redis缓存解决，项目可运行，详细注释(二)
 */
public class UserRedPacketServiceImpl implements UserRedPacketService {
    private static Logger log = LoggerFactory.getLogger(UserRedPacketServiceImpl.class);
    @Autowired
    TUserRedPacketMapper tUserRedPacketMapper;

    @Autowired
    TRedPacketMapper tRedPacketMapper;

    @Autowired
    RedPackDao redPackDao;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    RedisRedPacketService redisRedPacketService;


    //Lua脚本
    byte[] script = ("local listKey = 'red_packet_list_'..KEYS[1]\n"
            + "local redPacket = 'red_packet_'..KEYS[1] \n"
            + "local stock =tonumber(redis.call('hget',redPacket,'stock')) \n"
            + "if stock <=0 then return 0 end \n"
            + "stock = stock - 1 \n"
            //更新库存，对应TRedPacket表
            + "redis.call('hset',redPacket,'stock',tostring(stock)) \n"
            //插入抢到的红包记录，对应TUserRedPacket表
            + "redis.call('rpush',listKey,ARGV[1]) \n"
            //返回2提示没有库存了，指导更新返回信息。
            + "if stock == 0 then return 2 end \n"
            + "return 1 \n").getBytes();
    //在缓存 Lua 脚本后，使用该变量保存 Redis 返回的 32 位的 SHAl 编码，使用它去执行缓存的
    //Lua 脚本 sha编码
    String shal = null;


    /**
     * grapRedPacket 方法的逻辑是首先获取红包信息，如果发现红包库存大于 ，则说明
     * 有红包可抢，抢夺红包并生成抢红包的信息将其保存到数据库中。要注意的是，数据库事
     * 务方面的设置，代码中使用注解＠Transactional 说明它会在 个事务中运行，这样就能够
     * 保证所有的操作都是在－个事务中完成的。在高井发中会发生超发的现象，后面会看到超
     * 发的实际测试。
     *
     * @param redPacketId 红包编号
     * @param userId      用户编号
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Long grabRedPacket(Integer redPacketId, Integer userId) {
        String args = userId + "-" + System.currentTimeMillis();
        Long result;
        RedisConnection conn = (RedisConnection) redisTemplate.getConnectionFactory().getConnection();
        try {
            if (shal == null) {
                shal = conn.scriptLoad(script);
            }
            //i:用于指定键名参数的个数。

            byte[] KEYS = redisTemplate.getKeySerializer().serialize(redPacketId.toString());
            byte[] ARGV = redisTemplate.getValueSerializer().serialize(args);
            result = conn.evalSha(shal, ReturnType.INTEGER, 1, KEYS, ARGV);
            //result = conn.evalSha(shal, ReturnType.INTEGER, 1, redPacketId.toString().getBytes(), args.getBytes());
            //log.debug(result.toString());
            if (result == 2) {
                log.info("红包被抢完了，准备保存到数据库了");
                //获取单个红包的金额大小,unitAmount是单位量的意思。当然实际上肯定不能这么搞。
                Integer unitAmountI = (Integer) redisTemplate.opsForHash().get("red_packet_" + redPacketId, "unit_amount");
                double unitAmount = unitAmountI.doubleValue();
                //／触发保存数据库操作
                System.out.println("thread_name=" + Thread.currentThread().getName());
                redisRedPacketService.saveUserRedPacketByRedis(redPacketId, unitAmount);
            }
        }
        finally {
            //／确保 conn 关闭

            if (conn != null && !conn.isClosed()) {
                conn.close();

            }

        }
        return result;
    }
}

