package com.cdu.service;

import com.cdu.pojo.dto.UserRegDTO;

public interface UserService {
    /**
     * 用户注册
     * @param userRegDTO 用户注册信息
     */
    void reg(UserRegDTO userRegDTO);

}
