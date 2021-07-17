package com.demo.base.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//扫描mongodb接口所在的包，从而生成对应的bean
//不过貌似不配置这个也是可以的直接autowired接口，从而使用接口的方法的
@EnableMongoRepositories(basePackages = "com.demo.base.service")
public class MongoConfig {
}
