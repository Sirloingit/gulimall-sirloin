package com.fbw.common.exception;

/**
 * @author Sirloin
 * @Date 2021-02-2021/2/18-22:40
 */
public enum BizCodeExceptionEnum {
    UNKNOWN_EXCEPTION(10000,"其他异常"),

    VALID_EXCEPTION(10001, "数据校验异常");

    private Integer code;

    private String msg;

    BizCodeExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;


    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
