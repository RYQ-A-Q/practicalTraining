package com.cdu.commonts;

import lombok.Getter;
@Getter
public enum ServiceCode {
    OK(2000),//操作成功
    LOGIN_ERROR(4001),//登录失败
    REGISTER_ERROR(4002),//注册失败
    DATA_NOT_FOUND(4003),//数据不存在
    UPDATE_ERROR(4004),//更新/修改失败
    DELETE_ERROR(4005),//删除失败
    INSERT_ERROR(4006);//插入失败
    private int code;
    ServiceCode(int code) {
    }
}
