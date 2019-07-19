package com.uestc.common;

import java.io.Serializable;

/**
 * 返回格式基类
 * code 返回状态
 * msg 返回信息
 * Created by fucheng on 2018/4/29.
 */
public class Result implements Serializable{
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(){
        this.code = 1;
        this.msg = "ok";
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
