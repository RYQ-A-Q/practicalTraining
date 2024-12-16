package com.cdu.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegDTO {
    //用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    //密码
    @Length(min = 6, max = 12, message = "密码长度为{min}-{max}位")
    private String password;
    //确认密码
    @Length(min = 6, max = 12, message = "密码长度为{min}-{max}位")
    private String rePassword;
}
