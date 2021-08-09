package com.demo.mbg.mapper;

import com.demo.mbg.model.OmsPriceListAsc;
import com.demo.mbg.model.OmsPriceListAscExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsPriceListAscMapper {
    long countByExample(OmsPriceListAscExample example);

    int deleteByExample(OmsPriceListAscExample example);

    int insert(OmsPriceListAsc record);

    int insertSelective(OmsPriceListAsc record);

    List<OmsPriceListAsc> selectByExample(OmsPriceListAscExample example);

    int updateByExampleSelective(@Param("record") OmsPriceListAsc record, @Param("example") OmsPriceListAscExample example);

    int updateByExample(@Param("record") OmsPriceListAsc record, @Param("example") OmsPriceListAscExample example);
}