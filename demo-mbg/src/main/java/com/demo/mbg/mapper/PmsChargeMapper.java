package com.demo.mbg.mapper;

import com.demo.mbg.model.PmsCharge;
import com.demo.mbg.model.PmsChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsChargeMapper {
    long countByExample(PmsChargeExample example);

    int deleteByExample(PmsChargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsCharge record);

    int insertSelective(PmsCharge record);

    List<PmsCharge> selectByExample(PmsChargeExample example);

    PmsCharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsCharge record, @Param("example") PmsChargeExample example);

    int updateByExample(@Param("record") PmsCharge record, @Param("example") PmsChargeExample example);

    int updateByPrimaryKeySelective(PmsCharge record);

    int updateByPrimaryKey(PmsCharge record);
}