package com.demo.base.service;

import com.demo.mbg.mapper.UmsAdminDynamicSqlSupport;
import com.demo.mbg.mapper.UmsAdminMapper;
import com.demo.mbg.model.UmsAdmin;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.select;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.selectList;

@Service
public class UmsAdminDetailsService implements UserDetailsService {

    @Resource
    UmsAdminMapper umsAdminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UmsAdmin user;
        user = umsAdminMapper.selectByName(username);
        if (user ==null)throw new UsernameNotFoundException(username);

        //设置用户权限列表
        //在Security中，角色和权限共用GrantedAuthority接口，唯一的不同角色就是多了个前缀"ROLE_"，
        // 而且它没有Shiro的那种从属关系，即一个角色包含哪些权限等等。
        // 在Security看来角色和权限时一样的，它认证的时候，把所有权限（角色、权限）都取出来，而不是分开验证。
        Set<SimpleGrantedAuthority> sga =new HashSet<>();
        sga.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        user.setPermissions(sga);


        //返回查询到的user以供后续检验
        return user;
    }
}
