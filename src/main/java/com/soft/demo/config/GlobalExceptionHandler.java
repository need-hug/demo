package com.soft.demo.config;

import com.soft.demo.exception.BizException;
import com.soft.demo.util.Logger;
import com.soft.demo.util.MsgObj;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;

/** 全局异常处理
 * @Auther: lps
 * DateTime: 2019/4/16 17:43
 * @Version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MsgObj defaultErrorHandler(Exception e) {
        Logger.info("==========================全局异常处理开始==============================");

        MsgObj msgObj;
        if (e instanceof ValidationException) {
            msgObj = new MsgObj(401, "参数缺失");
        } else if (e instanceof MissingServletRequestParameterException) {
            msgObj = new MsgObj(402, "参数缺失");
        } else if (e instanceof BizException) {
            msgObj = new MsgObj(((BizException) e).getCode(), ((BizException) e).getMsg());
        } else {
            msgObj = new MsgObj(500, "系统繁忙");
        }
        Logger.info(e.getMessage());

        Logger.info("==========================全局异常处理结束==============================");
        return msgObj;
    }

}
