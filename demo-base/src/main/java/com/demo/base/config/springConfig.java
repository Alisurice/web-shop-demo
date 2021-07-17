package com.demo.base.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.demo.base.service","com.demo.common.config"})
public class springConfig {
}
