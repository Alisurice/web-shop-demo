package com.demo.security.config;

import com.demo.security.component.*;
import com.demo.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Slf4j
/**
 * 启动的子模块中一定要引入该jar包：hutool、jjwt，不然会有这个错误
 * Unsatisfied dependency expressed through field 'jwtTokenUtil'
 */
public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;

    @Override
    //注意这里调用的是
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{

        //log.debug("ignoreUrlsConfig :{}",ignoreUrlsConfig().getUrls());

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                registry = httpSecurity.authorizeRequests();

        //不需要保护的资源路径允许访问
        for (String url : ignoreUrlsConfig().getUrls()) {
            registry.antMatchers(url).permitAll();
        }

        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();

        registry.and()
                .authorizeRequests().anyRequest().authenticated();

        // 使用自定义的 accessDecisionManager
        if(dynamicSecurityService != null){
            log.debug("###accessDecisionManager");
            registry.accessDecisionManager(accessDecisionManager())
                    .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                        @Override
                        public <O extends FilterSecurityInterceptor> O postProcess(
                                O fsi) {
                            fsi.setSecurityMetadataSource(dynamicSecurityMetadataSource());
                            return fsi;
                        }
                    });

        }

                // 关闭跨站请求防护及不使用session
        registry.and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        registry.and()
                // 自定义权限拒绝处理类
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                //在用户名和密码校验前添加的过滤器，如果请求中有jwt的token且有效，会取出token中的用户名，然后调用SpringSecurity的API进行登录操作
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);




    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 之所以要加注解，要把内容配置为bean，大概就是希望spring扫描并启用这些类的注解？
     * 反正不加@Bean就没有加载到properties
     *
     * 因为SecurityConfig将被加上@Configuration，
     * 所以加了@Bean的方法都会被CGlib代理，从而返回单例，而不是返回一个独立实例
     *
     * 因为这个类在SecurityConfig被配置为bean，
     * 而SecurityConfig又被主模块的bean继承，
     * 所以这个bean会在主模块的auto scan的辖域下，从而ConfigurationProperties注解能够被spring扫描到，
     * 能够正确从主模块的yml中加载properties
     * 同时也可以看SecurityConfig的debug日志看看有没有成功打印出来。
     */
    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }


    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler() {
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }


    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }



    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public AccessDecisionManager accessDecisionManager() {
        // 构造一个新的AccessDecisionManager 放入两个投票器
        List<AccessDecisionVoter<?>> decisionVoters
                = Arrays.asList(new WebExpressionVoter(), accessDecisionProcessor());
        return new UnanimousBased(decisionVoters);
    }
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public AccessDecisionVoter<FilterInvocation> accessDecisionProcessor() {
        return new DynamicSecurityDecisionVoter();
    }
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        log.debug("########DynamicSecurityMetadataSource");
        return new DynamicSecurityMetadataSource();
    }


}
