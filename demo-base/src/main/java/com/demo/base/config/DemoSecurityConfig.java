package com.demo.base.config;

import com.demo.base.service.UmsAdminDetailsService;
import com.demo.security.config.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoSecurityConfig extends SecurityConfig {

    //这里怎样都可以，
    //只要能够生成这个名字 userDetailsService 的、实现了UserDetailsService接口的Bean就行
    @Bean
    public UserDetailsService userDetailsService(){
        return new UmsAdminDetailsService();
    }
}
