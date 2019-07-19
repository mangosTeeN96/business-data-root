package com.uestc.common;

/**
 * Created by fucheng on 2018/4/29.
 */
public enum StatEnum {
    SUCCESS(1001,"操作成功"),
    FAILED(1002,"操作失败"),
    LOGIN_SUCCESS(1003,"登录成功"),
    LOGIN_FAILED(1004,"登录失败，请重试！"),
    PASSWORD_ERROR(1005,"密码错误！")
    ;


    private int state;
    private String info;

    StatEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static StatEnum stateOf(int index)
    {
        for (StatEnum state : values())
        {
            if (state.getState()==index)
            {
                return state;
            }
        }
        return null;
    }
}
