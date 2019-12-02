package com.tdzx.user.utils;

/**
 * Author:Joker
 * Date:2018/7/19
 * Description:
 */
public enum ResultStatus implements BaseEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 注册失败
     */
    REGFAILD(300, "注册失败"),

    /**
     * 错误
     */
    ERROR(500, "错误"),
    /**
     * 异常
     */
    EXCEPTION(400, "异常"),

    /**
     * 权限校验失败
     */
    INVALIDSESSION(403, "无权限"),

    /**
     * 权限校验失败
     */
    NOTFOUND(404, "Not Found");

    /*NOMORETODAY=;*/

    private ResultStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    private int value;
    private String description;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

