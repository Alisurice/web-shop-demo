package com.demo.security.component;

import cn.hutool.core.collection.CollUtil;
import com.demo.security.config.IgnoreUrlsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Collection;

@Slf4j
public class DynamicSecurityDecisionVoter implements AccessDecisionVoter<FilterInvocation> {
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert object != null;

        // 拿到当前请求uri
        String requestUrl = object.getRequestUrl();
        String method = object.getRequest().getMethod();
        log.debug("进入自定义鉴权投票器，URI : {} {}", method, requestUrl);

        // 当接口未被配置资源时直接放行。如果没有缓存中没有此权限也就是未保护此API，弃权
        log.debug("attributes："+ attributes);
        if (CollUtil.isEmpty(attributes)) {
            return ACCESS_ABSTAIN;
        }
        //在放行列表中的就别鉴权了，直接放行。之所以要这样，是为了配合权限配置，避免权限配置覆盖了这些url？
        //当然，也可以写好resoure表的url拦截规则，但是那样更麻烦，所以还是这里多运转一下？
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoreUrlsConfig.getUrls()) {
            if(pathMatcher.match(path,object.getRequestUrl())){
                log.debug("直接放行");
                return ACCESS_GRANTED;
            }
        }
        //log.debug("before permitAll");

        //注意，attributes里面可能有permitAll？此时getAttribute为空
        int result = ACCESS_ABSTAIN;

        log.debug("鉴权");
        for (ConfigAttribute attribute : attributes)  {
            log.debug("attribute.getAttribute():{}",attribute.getAttribute());

            //如果数据源得到的权限限制为null，就可以交给别人决定是否允许访问，也就是这里弃权。
            //而只要数据源有一项权限限制，即getAttribute()有一次不为null，那都会把默认选项result的值改为ACCESS_DENIED
            if(attribute.getAttribute()==null){
                continue;
            }
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;

                //将访问所需资源或用户拥有资源进行比对
                log.debug("authentication:{}",authentication.getAuthorities());
                for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                    if (attribute.getAttribute().equals(grantedAuthority.getAuthority())) {
                        return ACCESS_GRANTED;
                    }
                }
            }




        }

        return result;

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
