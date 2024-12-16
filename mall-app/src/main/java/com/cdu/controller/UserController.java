package com.cdu.controller;

import com.cdu.pojo.dto.UserRegDTO;
import lombok.extern.slf4j.Slf4j;
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
    @PostMapping("reg")
    public Object register(@Validated UserRegDTO userRegDTO){
    log.info("用户注册信息:{}",userRegDTO);
    return userRegDTO;
    }

}
