package org.lengs.bitlogserver.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: lengs
 * @Date: 2024/6/1 15:08
 * @Description: 默认全局异常处理。
 * @Version: 1.0
 * @param: error the error
 * @return: ResultData
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception error) {
        log.error("全局异常信息 ex={}", error.getMessage(), error);
        return Result.error(Result.ReturnCode.RC500.getStatus(),error.getMessage());
    }
}
