package com.soft.demo.exception;

/** 业务异常
 * @Auther: lps
 * DateTime: 2019/4/16 11:28
 * @Version: 1.0
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code; // 状态码
    private String msg;   // 异常信息
    private String desc;  // 异常描述

    public BizException() {
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(Integer code, String msg, String desc) {
        super(desc);
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
