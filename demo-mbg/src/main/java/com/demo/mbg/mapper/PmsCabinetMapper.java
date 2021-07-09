package com.demo.mbg.mapper;

import com.demo.mbg.model.PmsCabinet;
import com.demo.mbg.model.PmsCabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsCabinetMapper {
    long countByExample(PmsCabinetExample example);

    int deleteByExample(PmsCabinetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsCabinet record);

    int insertSelective(PmsCabinet record);

    List<PmsCabinet> selectByExample(PmsCabinetExample example);

    PmsCabinet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsCabinet record, @Param("example") PmsCabinetExample example);

    int updateByExample(@Param("record") PmsCabinet record, @Param("example") PmsCabinetExample example);

    int updateByPrimaryKeySelective(PmsCabinet record);

    int updateByPrimaryKey(PmsCabinet record);
}