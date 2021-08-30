package com.demo.base.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfig {

    @Bean
    public PmsProductServiceImpl pmsProductService(){
        return new PmsProductServiceImpl();
    }
}
