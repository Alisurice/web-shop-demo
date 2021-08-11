package com.demo.security.component;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

@Slf4j
public class DynamicSecurityDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

    @Override
    public int vote(Authentication authentication, FilterInvocation object, Collection<ConfigAttribute> attributes) {
        assert authentication != null;
        assert object != null;

        // 拿到当前请求uri
        String requestUrl = object.getRequestUrl();
        String method = object.getRequest().getMethod();
        log.debug("进入自定义鉴权投票器，URI : {} {}", method, requestUrl);

        // 当接口未被配置资源时直接放行。如果没有缓存中没有此权限也就是未保护此API，弃权
        log.debug("ACCESS_ABSTAIN：attributes："+ attributes);
        if (CollUtil.isEmpty(attributes)) {
            return ACCESS_ABSTAIN;
        }
        //log.debug("before permitAll");

        //注意，attributes里面可能有permitAll？此时getAttribute为空
        int result = ACCESS_ABSTAIN;

        //log.debug("鉴权");
        for (ConfigAttribute attribute : attributes)  {
            //如果数据源得到的权限限制为null，就可以交给别人决定是否允许访问，也就是这里弃权。
            //而只要数据源有一项权限限制，即getAttribute()有一次不为null，那都会把默认选项result的值改为ACCESS_DENIED
            if(attribute.getAttribute()==null){
                continue;
            }
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;
                //log.debug("before supports");

                //将访问所需资源或用户拥有资源进行比对
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
