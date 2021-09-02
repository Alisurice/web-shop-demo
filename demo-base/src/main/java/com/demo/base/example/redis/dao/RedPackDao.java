package com.demo.base.example.redis.dao;

import org.apache.ibatis.annotations.Update;

public interface RedPackDao {

    @Update("update t_red_packet set stock = stock -1 where id = #{id}")
     int decreaseRedPack(long id);
}
