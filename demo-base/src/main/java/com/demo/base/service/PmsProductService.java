package com.demo.base.service;

import com.demo.base.vo.PmsProductParam;
import org.springframework.transaction.annotation.Transactional;

public interface PmsProductService {

    @Transactional
    int create(PmsProductParam pmsProductParam);
}
