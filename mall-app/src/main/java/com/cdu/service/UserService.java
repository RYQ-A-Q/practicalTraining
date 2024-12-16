package com.cdu.service;

import com.cdu.pojo.dto.UserRegDTO;
import com.cdu.pojo.entity.User;

public interface UserService {
    /**
     * 用户注册
     * @param userRegDTO 用户注册信息
     */
    void reg(UserRegDTO userRegDTO);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码（加密前）
     */
    User login(String username, String password);

}
