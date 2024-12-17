package com.cdu.commonts;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public class R <T>{
    //业务码
    private  int code;
    //信息
    private String msg;
     // 数据
    private T data;

}
