package org.example.blogssystem.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.blogssystem.common.Exception.BlogException;
import org.example.blogssystem.pojo.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        log.error("系统异常", e.getMessage());
        return Result.fail("系统繁忙，请稍后重试");
    }
}
