package com.eugene.common.controller;

import com.eugene.common.exception.BusinessException;
import com.eugene.common.web.http.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理异常控制器, 但它不是一个正在的控制器
 */
public class BaseController {

    private static final String DEFAULT_ERROR_MESSAGE = "系统异常";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Message exceptionHandler(Exception e) {
        String errorMessage = DEFAULT_ERROR_MESSAGE;
        if (e instanceof BusinessException) {
            errorMessage = e.getMessage();
        }

        return Message.error(errorMessage);
    }
}
