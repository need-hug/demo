package com.soft.framework.exception;

/** 不打印堆栈信息的异常工具类
 * className: UnFillStackTraceException
 * author: peishuai.li
 * dateTime: 2019/6/5 16:05
 * version: 1.0
 */
public class UnFillStackTraceException extends RuntimeException {

    public UnFillStackTraceException() {
        this(null, null);
    }

    public UnFillStackTraceException(String message) {
        this(message, null);
    }

    public UnFillStackTraceException(Throwable cause) {
        this(null, cause);
    }

    public UnFillStackTraceException(String message, Throwable cause) {
        super(message, cause, false, false);
    }
}
