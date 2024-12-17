package com.cdu.commons;

import lombok.Getter;
@Getter
public enum ServiceCode {
    OK(2000),//操作成功
    LOGIN_ERROR(4001),//登录失败
    REGISTER_ERROR(4002),//注册失败
    DATA_NOT_FOUND(4003),//数据不存在
    UPDATE_ERROR(4004),//修改失败
    DELETE_ERROR(4006),//删除失败
    INSERT_ERROR(4007),//新增失败
    REQUEST_ERROR(4008),//错误请求
    DATA_CHECK_ERROR(4009),//数据校验有误
    PATH_NOT_FOUND(40010),//请求路径不存在
    ERROR_TOKEN(40011),//token错误
    UN_KNOW_ERROR(9999);//未知错误

    //....
    private int code;

    private ServiceCode(int code) {
        this.code = code;
    }
}
