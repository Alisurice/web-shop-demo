package com.demo.mbg.mapper;

import com.demo.mbg.model.TUserRedPacket;
import com.demo.mbg.model.TUserRedPacketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserRedPacketMapper {
    long countByExample(TUserRedPacketExample example);

    int deleteByExample(TUserRedPacketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserRedPacket record);

    int insertSelective(TUserRedPacket record);

    List<TUserRedPacket> selectByExample(TUserRedPacketExample example);

    TUserRedPacket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserRedPacket record, @Param("example") TUserRedPacketExample example);

    int updateByExample(@Param("record") TUserRedPacket record, @Param("example") TUserRedPacketExample example);

    int updateByPrimaryKeySelective(TUserRedPacket record);

    int updateByPrimaryKey(TUserRedPacket record);
}