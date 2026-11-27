package org.example.blogssystem.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.blogssystem.common.exception.BlogException;
import org.example.blogssystem.pojo.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    /** 业务异常：可预期的错误，返回友好提示 */
    @ExceptionHandler
    public Result blogException(BlogException e) {
        log.warn("业务异常: {}", e.getMessage());
        return Result.fail(e.getMessage());
    }

    /** 兜底：未预期异常，记 error，不把内部细节返回给前端 */
    @ExceptionHandler
    public Result exception(Exception e) {
//        log.error("系统异常", e.getMessage());
        log.error("系统异常", e);
        return Result.fail("系统繁忙，请稍后重试");
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result nullexception(IllegalStateException e) {
        //那个博客注解
        log.error("为空", e);
        return Result.fail("id为空");
    }

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public Result blogException(MethodArgumentNotValidException e) {
        //密码或者用户为空
        log.warn("业务异常: {}", e.getMessage());
        //有办法取具体信息
//        String msg = e.getBindingResult().getFieldError().getDefaultMessage();   // "密码不能为空"
//        return Result.fail(msg);
        return Result.fail("啥玩意为空了");
    }
}
