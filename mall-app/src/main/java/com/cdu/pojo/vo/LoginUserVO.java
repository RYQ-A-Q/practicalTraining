package com.cdu.pojo.vo;

import lombok.Data;

@Data
public class LoginUserVO {
    private int id;
    private String username;
    private String avatar;
    private String token;

    public LoginUserVO(int id, String username, String avatar, String token) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.token = token;
    }

    public LoginUserVO() {
    }
}
