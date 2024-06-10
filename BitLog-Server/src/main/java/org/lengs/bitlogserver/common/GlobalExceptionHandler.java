package org.lengs.bitlogserver.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception error) {
        //log.error("全局异常信息 >>>{}", error.getMessage(), error);
        log.error("全局异常信息 >>> " + error);
        //log.error("使用 + 号连接直接输出 e.getMessage() : " + error.getMessage());
        //log.error("使用 + 号连接直接输出 e.toString() : " + error.toString());
        // 使用逗号分隔，调用两个参数的error方法
        //log.error("使用 , 号 使第二个参数作为Throwable : ", error);
        // 尝试使用分隔符,第二个参数为Throwable,会发现分隔符没有起作用，第二个参数的不同据，调用不同的重载方法
        //log.error("第二个参数为Throwable，使用分隔符打印 {} : ", error);
        // 尝试使用分隔符，第二个参数为Object,会发现分隔符起作用了，根据第二个参数的不同类型，调用不同的重载方法
        //log.error("第二个参数为Object，使用分隔符打印 {} ",123);
        return Result.error(ResultCode.FAIL.getStatus(),error.getMessage());
    }
}
