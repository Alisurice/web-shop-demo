package com.demo.base.service;

import com.demo.mbg.model.UmsAdmin;

/**
 * 后台用户管理Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    UmsAdmin register(UmsAdmin umsAdmin);
    UmsAdmin getAdminByUsername(String username);
    String login(String username, String password);

}
