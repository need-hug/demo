package com.soft.framework.config;

import com.soft.framework.entity.StatusCode;
import com.soft.framework.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * className: ExceptionHandler
 * author: peishuai.li
 * dateTime: 2019/6/5 17:02
 * version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public StatusCode defaultErrorHandler(Exception e) {

        log.info(e.getMessage());

        if (e instanceof APIException) {
            return ((APIException) e).getStatusCode();
        } else {
            return StatusCode.ERROR;
        }
    }

}
