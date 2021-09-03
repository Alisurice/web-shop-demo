package com.demo.base.example.redis.service.impl;

import com.demo.base.example.redis.service.RedisRedPacketService;
import com.demo.mbg.model.TUserRedPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedisRedPacketServiceImpl implements RedisRedPacketService {
    private static final Logger log = LoggerFactory.getLogger(RedisRedPacketServiceImpl.class);
    private static final String PREFIX = "red_packet_list_";
    //每次取出 1000 ，避免一次取出消耗太多内存
    //1000不行，不知道为什么直接就返回了
    private static final int TIME_SIZE = 1000;

    @Autowired
    private RedisTemplate redisTemplate;

    @Async
    @Override
    public void saveUserRedPacketByRedis(Integer redPacketId, Double unitAmount) {
        log.info("保存redis抢红包数据");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //这个list就对应着t_UserRedPacket表，对应着要插入的所有记录
        BoundListOperations ops = redisTemplate.boundListOps(PREFIX+redPacketId);
        //确定要插入多少条数据。
        Long size = ops.size();
        //计算确定单次插入TIME_SIZE个数据下，要运行几次。运行的次数就是times
        //这样做是为了避免redis卡顿
        long times = size%TIME_SIZE==0?size/TIME_SIZE:size/TIME_SIZE+1;

        int count = 0;
        //这里就是一个DTO，方便后续插入到数据库。
        List<TUserRedPacket> userRedPacketList = new ArrayList<TUserRedPacket>();
        for(int i=0;i<times;i++){
            //获取至多 TIME SIZE 个抢红包信息，这个就是BO，Bussiness Object
            List userIdList = null;
            if(i==0){
                userIdList = ops.range(i*TIME_SIZE, (i+1)*TIME_SIZE);
            }else{
                userIdList = ops.range(i*TIME_SIZE+1, (i+1)*TIME_SIZE);
            }

            userRedPacketList.clear();
            log.debug("####"+userIdList.size()+"###"+times);
            //保存红包信息，BO转DTO
            for(Object record : userIdList){
                String args = (String) record;
                String[] arr = args.split("-");
                String userIdStr = arr[0];
                String timeStr = arr[1];
                int userId = Integer.parseInt(userIdStr);
                long time = Long.parseLong(timeStr);

                //生产抢红包信息DTO
                TUserRedPacket userRedPacket = new TUserRedPacket();
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setUserId(userId);
                userRedPacket.setAmount(new BigDecimal(unitAmount));
                userRedPacket.setGrabTime(new Timestamp(time));
                userRedPacket.setNote("抢红包"+redPacketId);

                userRedPacketList.add(userRedPacket);
            }
            //插入抢红包信息
            count += executeBatch(userRedPacketList);
        }
        redisTemplate.delete(PREFIX+redPacketId);
        stopWatch.stop();
        log.info("保存数据结束 耗时:{}秒 保存记录数：",stopWatch.getTotalTimeSeconds(),count);

    }

    @Autowired
    private DataSource dataSource;
    private int executeBatch(List<TUserRedPacket> userRedPacketList){
        Connection conn = null;
        Statement stmt = null;
        int[] count = null;

        try{
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            //开启事务
            conn.setAutoCommit(false);

            for(int i = 0; i <userRedPacketList.size(); i++){
                TUserRedPacket userRedPacket = userRedPacketList.get(i);
                String updateSql = "update T_RED_PACKET set stock = stock-1 where id = "
                        +userRedPacket.getRedPacketId();
                ////不能用这个，这个会直接报错都没有，就直接程序结束了。
                //String updateStock = new SQL() {
                //    {
                //        //这是SQL对象的父类方法。
                //        UPDATE("T_RED_PACKET");
                //        SET("stock = stock-1");
                //        WHERE("where id = "+userRedPacket.getRedPacketId());
                //    }
                //}.toString();

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String insertSql = "insert into T_USER_RED_PACKET(red_packet_id,user_id,"+
                        "amount ,grab_time,note) "
                        +"values("+userRedPacket.getRedPacketId()+","
                        +userRedPacket.getUserId()+","
                        +userRedPacket.getAmount()+","
                        +"'"+df.format(userRedPacket.getGrabTime())+"',"
                        +"'"+userRedPacket.getNote()+"')";
                stmt.addBatch(updateSql);
                stmt.addBatch(insertSql);
                log.debug(String.valueOf(i));
            }
            log.debug("准备批量执行");
            //执行批量
            count = stmt.executeBatch();
            log.debug("执行完成：count"+count);
            //提交事务
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("抢红包批量执行程序错误");

        }
        //catch (Exception e){
        //    e.printStackTrace();
        //}
        finally{
            try {
                stmt.close();
                if(conn != null &&!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回插入抢红包数据记录（因为一条record的插入对应了update和insert两次操作），所以要/2
        return count.length/2;
    }

}
