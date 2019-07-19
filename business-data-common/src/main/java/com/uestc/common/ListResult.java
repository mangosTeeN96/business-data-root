package com.uestc.common;

/**
 * 列表形式的返回数据格式
 * total 总行数(分页用到)
 * rows 当前显示的行信息list
 * Created by fucheng on 2018/4/29.
 */
public class ListResult extends Result {
    private Integer total;
    private Object rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public ListResult(Integer code, String msg, Integer total, Object rows) {
        super(code, msg);
        this.total = total;
        this.rows = rows;
    }
}
