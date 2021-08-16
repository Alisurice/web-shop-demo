# 商城项目 spring boot demo
[toc]
## 项目介绍
本商城项目基于[mall商城](https://github.com/macrozheng/mall)
### 技术选型

| 技术                 | 说明                | 官网                                           |
| -------------------- | ------------------- | ---------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot         |
| SpringSecurity       | 认证和授权框架      | https://spring.io/projects/spring-security     |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | 数据层代码生成      | http://www.mybatis.org/generator/index.html    |
| Redis                | 分布式缓存          | https://redis.io/                              |
| JWT                  | JWT登录支持         | https://github.com/jwtk/jjwt                   |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok         |
| Hutool               | Java工具类库        | https://github.com/looly/hutool                |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI           | 文档生成工具        | https://github.com/swagger-api/swagger-ui      |
###TODOList
-[ ] jwt注销功能。
    > 目前的实现思路是用redis记录所有登录对象的token，并在注销时在redis中删除对应token。为了让注销生效，还要修改jwtTokenUtil.validateToken,如果在redis中检索不到token，那这个token也是无效的。   
-[ ] 统计一个角色对应的用户数量，并记录在ums_role表的adminCount字段，
    > 要让这个字段有效，我们可以修改updateRole，让他增删的时候都修改ums_role，因为要在原有基础上进行增减，所以这里要设定事务，设定为可重复读。  
    或者暴力一点，在调用roleService.list()的时候再统计。这个可以用mybatis的多表关联查询实现
##用户管理模块UMS
主要是在后台用户管理模块中创建和管理用户的权限、角色。  
在角色管理中创建角色，以及管理角色在资源、菜单上的访问权限。  
而资源、菜单管理，则主要是用来为资源、菜单api加上访问权限
###1. 用户与用户权限管理
####后台用户管理 UmsAdminController
> - 用户注册、登录、注销接口
> - 用户信息、状态查询修改接口，
> - 用户角色查询修改接口，为用户赋予角色
###2. 权限管理
 ####后台用户角色管理UmsRoleController
> - 增删改查角色
> - 给角色分配菜单
> - 给角色分配资源
 ####后台资源管理UmsResourceController
> - 增删改查资源
####后台菜单管理UmsMenuController
> - 增删改查菜单


## Spring Security
[Spring Security 基本原理](document/basicPrinciples.jpg)
### 大概的运转过程
####1. SecurityContextPersistenceFilter
>SecurityContextPersistenceFilter是Security的拦截器，而且是拦截链中的第一个拦截器，请求来临时它会从HttpSession中把SecurityContext取出来，然后放入SecurityContextHolder。在所有拦截器都处理完成后，再把SecurityContext存入HttpSession，并清除SecurityContextHolder内的引用。

####2.UsernamePasswordAuthenticationFilter
>负责认证的过滤器。负责根据所请求的服务对身份证的认证情况的要求，过滤请求的过滤器
      
####3. ExceptionTranslationFilter
>负责异常处理

####4. FilterSecurityInterceptor
>负责授权。负责根据服务对权限的要求，过滤请求

####5. Controller、Service、Dao
>通过了前面的拦截器后，就开始调用服务响应请求了。具体来说，就是触发request对应的controller响应请求。

### 直观的运转过程
1. 通用框架
2. 展示了登录的过程，展示了要实现自定义登录功能，需要如何配置Spring Security的各个filter
3. 展示了请求其他服务的过程，展示了如何进行认证拦截、权限拦截
[SpringSecurity运转过程.html](document/SpringSecurityProcedure.mht)

### Spring Security的具体实现以及如何进行拓展
>  直观展示：[Realization.mht](document/Realization.mht)
1. 展示了这些filter的处理过程，简单地画了一下流程图、调用链
    > - JwtAuthenticationTokenFilter
    > - UsernamePasswordAuthenticationFilter
    > - FilterSecurityInterceptor    
    
2. 展示了常用的拓展点的实现的关键节点，描述了这些拓展点的功能、所处的位置
    - 用于实现RememberMe功能，避免反复登录的拓展点
        - JwtAuthenticationTokenFilter，主要介绍了一下如何配置，以及这个filter的功能
            >通过请求携带的JWT token直接登录，跳过UsernamePasswordAuthenticationFilter
            
    - 认证过滤器UsernamePasswordAuthenticationFilter的拓展点
        - PasswordEncoder 
            > 可以修改加密明文密码的方式，registerApi注册新用户时采用了什么加密方式，这里就配置什么加密方式。
        - UserDetailsService 
            >可以修改用于比对身份信息数据源，换一个数据源来进行身份认证时的信息配对。
        
    - 权限拦截器FilterSecurityInterceptor的拓展点
        - FilterInvocationSecurityMetadataSource
            > Spring Securtiy会从MetadataSource中获取服务要求的权限列表，并把权限列表封装到Collection<ConfigAttribute>中。  
            我们可以通过配置数据源，从而修改权限列表的来源。        
        - AuthenticatedVoter
            > 拓展投票方式。可以自定义投票规则，根据期望权限列表和实际权限列表的比较情况，自定义要返回的投票结果（ACCESS_GRANTED、ABSTAIN DENIED）  
            实现期望权限和实际权限的比较函数，然后定义比较结果和投票结果的映射关系，并根据映射关系返回投票结果。这就是Voter要做的事情。  
            AccessDecisionManager会接收Voter的投票结果，并综合多个Voter的投票结果，再根据自身的映射关系，决定是放行，还是拦截。
        - AccessDecisionManager
            > 拓展决定方式，方式根据自己的原则汇总分析多个voter的投票结果的，从而决定是否放行  
            不放行时throw new AccessDeniedException
                                                              
                具体有这些决定方式、决定原则：
                1. AffirmativeBased：一票通过，只要有一票通过就算通过，默认是它。  
                2. UnanimousBased：一票反对，只要有一票反对就不能通过。  
                3. ConsensusBased：少数票服从多数票。
3. 怎样完成拓展，怎样配置这些拓展点  
    通常来说，只要建立用于替换拓展点的Bean，并在继承了WebSecurityConfigurerAdapter的config实现类中，重写相应configure方法就行。  
    具体过程类似使用Builder的各种配置方法来初始化一个类？总之，这就可以将自定义的Bean注入到Spring Security了，从而实现拓展、实现自定义了。
    > 不过权限拦截器的拓展点的配置有点特殊。AuthenticatedVoter要注入到AccessDecisionManager。  
    也就是说，要在Manager中配置好Voter、增加Voter。在config中我们只能拓展Manager。  
    具体来说，我们要在构造Mananger实例的时候，将要配置的Voter作为构造器的参数传入。
    
###参考资料
- [SpringSecurity+JWT认证流程解析 | 掘金新人第一弹](https://juejin.cn/post/6846687598442708999)
- [SpringSecurity动态鉴权流程解析 | 掘金新人第二弹](https://juejin.cn/post/6847902222668431368)
- [【龙飞】Spring Security 源码分析一：Spring Security 认证过程](https://www.iocoder.cn/Spring-Security/longfei/The-authentication-process/)
- [【龙飞】Spring Security 源码分析二：Spring Security 授权过程](https://www.iocoder.cn/Spring-Security/longfei/The-authorization-process/)
- [Spring Security详解（三）认证之核心过滤器](https://blog.csdn.net/sinat_29899265/article/details/80747924)
- [spring security实现动态配置url权限的两种方法](https://www.cnblogs.com/xiaoqi/p/spring-security-rabc.html)
- [手把手教你搞定权限管理，结合Spring Security实现接口的动态权限控制！](http://www.macrozheng.com/#/technology/permission_back?id=%e5%9f%ba%e4%ba%8e%e8%b7%af%e5%be%84%e7%9a%84%e5%8a%a8%e6%80%81%e6%9d%83%e9%99%90%e6%8e%a7%e5%88%b6)
- [【龙飞】Spring Security 源码分析七：Spring Security 记住我](https://www.iocoder.cn/Spring-Security/longfei/Remember-Me/)


     
                                
                    

