package com.cdu.controller;

import com.cdu.pojo.dto.UserLoginDTO;
import com.cdu.pojo.dto.UserRegDTO;
import com.cdu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("reg")//注册
    public Object register( @Validated UserRegDTO userRegDTO){
        log.debug("用户注册信息:{}",userRegDTO);
        userService.reg(userRegDTO);
        return "注册成功";
    }
    @PostMapping("login")//登录
    public Object login(@Validated UserLoginDTO userLoginDTO){
        return userService.login(userLoginDTO);
    }
}
