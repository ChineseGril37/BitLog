package org.lengs.bitlogserver.common;

import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description: 自定义全局返回格式Result
 * @Version: 1.0
 */
@Data
public class Result<T> {
    // 结果状态码
    private int status;
    // 响应信息
    private String message;
    // 响应数据
    private T data;
    // 接口请求时间
    private String timestamp;
    public Result(){
        //对接口调用时间进行数据规范化(yyyy-MM-dd HH:mm:ss),
        timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setStatus(ResultCode.SUCCESS.getStatus());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <t> Result<t> error(int code, String message) {
        Result<t> result = new Result<>();
        result.setStatus(code);
        result.setMessage(message);
        return result;
    }
}
