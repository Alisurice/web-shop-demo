package com.demo.base.service.impl;

import com.demo.base.service.UmsAdminService;
import com.demo.mbg.mapper.UmsAdminMapper;
import com.demo.mbg.model.UmsAdmin;
import com.demo.security.exception.Asserts;
import com.demo.security.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 后台用户管理Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Resource
    private UmsAdminMapper adminMapper;



    public UmsAdmin getAdminByUsername(String username) {
        return adminMapper.selectByName(username);
    }


    public UmsAdmin register(UmsAdmin umsAdmin) {

        if (adminMapper.selectByName(umsAdmin.getUsername()) != null) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }


    public String login(String username, String password) {
        log.debug("username: {}, password:{}",username,password);
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            log.debug("userDetails password:{}",userDetails.getPassword());
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                Asserts.fail("帐号已被禁用");
            }

            //参考 Spring Security实现RBAC权限管理：
            //• 如果验证成功，会将返回的 result 既 Authentication 对象进一步封装为 Authentication Token；
            //比如 UsernamePasswordAuthenticationToken、RememberMeAuthenticationToken 等；
            // 这些 Authentication Token 也都继承自 Authentication 对象；
            //credentials应该是指证书之类的特殊的认证信息
            UsernamePasswordAuthenticationToken authentication
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            //保存到对应的上下文中，这样同一个对话对应的用户以后就不用重新登录了
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);

        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }



    //参考UmsAdminDetailsService
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            Set<SimpleGrantedAuthority> sga =new HashSet<>();
            sga.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            admin.setPermissions(sga);
            return admin;
        }

        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
