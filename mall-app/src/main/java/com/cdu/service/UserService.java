package com.cdu.service;

import com.cdu.pojo.dto.UserLoginDTO;
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
     * @param userLoginDTO 用户登录信息
     */
    User login(UserLoginDTO userLoginDTO);

}
