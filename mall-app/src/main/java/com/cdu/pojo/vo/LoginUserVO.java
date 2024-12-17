package com.cdu.pojo.vo;

import lombok.Data;

@Data
public class LoginUserVO {
    private int id;
    private String username;
    private String avatar;
    private String token;
}
