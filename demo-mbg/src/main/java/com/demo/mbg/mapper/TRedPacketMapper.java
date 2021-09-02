package com.demo.mbg.mapper;

import com.demo.mbg.model.TRedPacket;
import com.demo.mbg.model.TRedPacketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRedPacketMapper {
    long countByExample(TRedPacketExample example);

    int deleteByExample(TRedPacketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRedPacket record);

    int insertSelective(TRedPacket record);

    List<TRedPacket> selectByExample(TRedPacketExample example);

    TRedPacket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRedPacket record, @Param("example") TRedPacketExample example);

    int updateByExample(@Param("record") TRedPacket record, @Param("example") TRedPacketExample example);

    int updateByPrimaryKeySelective(TRedPacket record);

    int updateByPrimaryKey(TRedPacket record);
}