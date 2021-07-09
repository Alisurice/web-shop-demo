package com.demo.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan(basePackages = {"com.share.charge.controller"}) //必须存在 扫描的API Controller package name 也可以直接扫描class (basePackageClasses)
@Configuration //必须存在
@EnableSwagger2 //必须存在
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //apiInfo指定测试文档基本信息，这部分将在页面展示
                .apiInfo(apiInfo())
                .select()
                //apis() 控制哪些接口暴露给swagger，
                // RequestHandlerSelectors.any() 所有都暴露
                // RequestHandlerSelectors.basePackage("com.info.*")  指定包位置
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    //基本信息，页面展示
    private ApiInfo apiInfo() {
        Contact contact =new Contact("名字", "网址", "邮箱");
        return new ApiInfoBuilder()
                .title("测试项目标题")
                .description("接口描述")
                //联系人实体类
                .contact(contact)
                //版本号
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}

