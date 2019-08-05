package com.soft.framework.entity;

/** 异常状态
 * className: StatusCode
 * author: peishuai.li
 * dateTime: 2019/6/5 16:09
 * version: 1.0
 */
public enum StatusCode {

    SUCCESS(200000, "成功"),
    FAIL(404000, "失败"),
    ERROR(500000, "系统繁忙"),
    NO_PARAM(404100, "缺失必要参数");


    public final int code;
    public final String defaultMsg;

    StatusCode(int code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public static StatusCode valueOf(int code) {
        for (StatusCode value : StatusCode.values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("没有符合'" + code + "'的StatusCode");
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code=" + code +
                ", defaultMsg='" + defaultMsg + '\'' +
                '}';
    }
}
