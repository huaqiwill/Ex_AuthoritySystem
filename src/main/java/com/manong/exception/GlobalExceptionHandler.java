package com.manong.exception;

import com.manong.utils.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo doHandleException(Exception e) {
        e.printStackTrace();
        return ResultVo.fail(e.getMessage());
    }
}