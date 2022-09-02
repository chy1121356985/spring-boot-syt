package com.chy.common.exception;


import com.chy.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 11213
 * 异常捕捉
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常 自动补捕获
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    //自定义异常 手动抛出
    @ExceptionHandler(YyghException.class)
    @ResponseBody
    public Result error(YyghException e) {
        e.printStackTrace();
        return Result.fail();
    }
}
