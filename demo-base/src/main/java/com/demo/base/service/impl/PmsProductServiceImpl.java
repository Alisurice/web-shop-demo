package com.demo.base.service.impl;

import com.demo.base.dao.PmsMemberPriceDao;
import com.demo.base.service.PmsProductService;
import com.demo.base.vo.PmsProductParam;
import com.demo.mbg.mapper.PmsProductMapper;
import com.demo.mbg.model.PmsProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

//@Service
@Slf4j
public class PmsProductServiceImpl implements PmsProductService {
    @Resource
    private PmsProductMapper pmsProductMapper;
    @Resource
    private PmsMemberPriceDao pmsMemberPriceDao;

    @Override
    public int create(PmsProductParam productParam) {
        int count;
        PmsProduct product = productParam;
        product.setId(null);
        pmsProductMapper.insertSelective(product);
        //根据促销类型设置价格：会员价格、阶梯价格、满减价格
        Long productId = product.getId();
        //会员价格
        relateAndInsertList(pmsMemberPriceDao, productParam.getMemberPriceList(), productId);
        count = 1;
        return count;
    }


    /**
     * 建立和插入关系表操作
     *
     * @param dao       可以操作的dao
     * @param dataList  要插入的数据
     * @param productId 建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        } catch (Exception e) {
            log.warn("创建产品出错:{}", e.getCause());
            throw new RuntimeException(e.getMessage());
        }
    }
}
