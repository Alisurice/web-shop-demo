package com.demo.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于配置白名单资源路径
 * Created by macro on 2018/11/5.
 * 因为这个类在SecurityConfig被配置为bean，
 * 而SecurityConfig又被主模块的bean继承，
 * 所以这个bean会在主模块的auto scan的辖域下，从而ConfigurationProperties注解能够被spring扫描到，
 * 能够正确从主模块的yml中加载properties
 * 同时也可以看SecurityConfig的debug日志看看有没有成功打印出来。
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

}
