package com.tdzx.user.utils;

import java.io.Serializable;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
public class CommonResult<T> implements Serializable {

    /**
     * 1:成功
     * 0：失败
     * 2：token过期
     * 3:未绑定微信
     * 4:是新用户（用于绑定的微信的时候）
     * 5.0元支付成功
     * 6.不在征订期
     * 7.没有注册
     *
     */
    private long code;
    private String message;
    private T data;

    public CommonResult() {
        super();
    }

    private CommonResult(T data) {
        this.data = data;
    }

    private CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
