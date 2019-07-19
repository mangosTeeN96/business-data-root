package com.uestc.common;

/**
 * Created by fucheng on 2019/7/15.
 * 对象信息的返回数据格式
 * data 当前需要返回的数据对象
 */
public class DataResult extends Result{
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataResult(Integer code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }
}
