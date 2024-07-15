package org.lengs.bitlogserver.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

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
    public Result<String> exception(Exception error)    {
        logger(error);
        return Result.error(ResultCode.FAIL.getStatus(),error.getMessage());
        /*
        log.error("全局异常信息 >>>{}", error.getMessage(), error);
        log.error("使用 + 号连接直接输出 e.getMessage() : " + error.getMessage());
        log.error("使用 + 号连接直接输出 e.toString() : " + error.toString());
         使用逗号分隔，调用两个参数的error方法
        log.error("使用 , 号 使第二个参数作为Throwable : ", error);
         尝试使用分隔符,第二个参数为Throwable,会发现分隔符没有起作用，第二个参数的不同据，调用不同的重载方法
        log.error("第二个参数为Throwable，使用分隔符打印 {} : ", error);
         尝试使用分隔符，第二个参数为Object,会发现分隔符起作用了，根据第二个参数的不同类型，调用不同的重载方法
        log.error("第二个参数为Object，使用分隔符打印 {} ",123);
        */
    }
    @ExceptionHandler(RuntimeException.class)
    public Result<String> runtimeException(RuntimeException error){
        logger(error);
        return Result.error(ResultCode.DATABASE_OPERATION_FAILED.getStatus(),error.getMessage());
    }
    @ExceptionHandler(ArithmeticException.class)
    public Result<String> arithmeticException(ArithmeticException error){
        String msg = error.getMessage();
        if(Objects.equals(error.getMessage(), "/ by zero")){
            msg = "除法中除数为零";
        }
        logger(error);
        return Result.error(ResultCode.ARITHMETIC_OPERATION_FAILED.getStatus(),msg);
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Result<String> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException error){
        logger(error);
        return Result.error(ResultCode.ARRAY_INDEX_OUT.getStatus(),"数组越界");
    }
    private static void logger(Exception error){
        log.error("=================================================================================ERROR==================================================================================");
        log.error("异常信息 >>> " + error);
        log.error("========================================================================================================================================================================");
    }
}
