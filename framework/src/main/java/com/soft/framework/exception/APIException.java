package com.soft.framework.exception;

import com.soft.framework.entity.StatusCode;
import com.soft.framework.util.StringUtils;

/** 接口响应异常类
 * className: APIException
 * author: peishuai.li
 * dateTime: 2019/6/5 16:07
 * version: 1.0
 */
public class APIException extends UnFillStackTraceException {

    private final StatusCode statusCode;

    public APIException(StatusCode statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public APIException(String message, StatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getMessage() {
        return StringUtils.defaultIfBlank(super.getMessage(), statusCode.toString());
    }
}
