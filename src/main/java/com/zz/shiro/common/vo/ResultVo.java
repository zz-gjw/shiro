package com.zz.shiro.common.vo;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/5 14:56
 * @Description:
 */
public class ResultVo {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

}
