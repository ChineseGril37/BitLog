package org.lengs.bitlogserver.common;

import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description:
 * @Version: 1.0
 */
@Data
public class Result<T> {
    // 结果状态码
    private int status;
    // 响应信息
    private String msg;
    // 响应数据
    private T data;
    // 接口请求时间
    private String timestamp;
    public Result(){
        //对接口调用时间进行数据规范化(yyyy-MM-dd HH:mm:ss),
        timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public static <t> Result<t> success(t data) {
        Result<t> result = new Result<>();
        result.setStatus(ReturnCode.RC100.getStatus());
        result.setMsg(ReturnCode.RC100.getMessage());
        result.setData(data);
        return result;
    }

    public static <t> Result<t> error(int code, String message) {
        Result<t> result = new Result<>();
        result.setStatus(code);
        result.setMsg(message);
        return result;
    }
    @Getter
    public enum ReturnCode {
        /**操作成功**/
        RC100(100,"操作成功"),
        /**操作失败**/
        RC999(999,"操作失败"),
        /**服务限流**/
        RC200(200,"服务开启限流保护,请稍后再试!"),
        /**服务降级**/
        RC201(201,"服务开启降级保护,请稍后再试!"),
        /**热点参数限流**/
        RC202(202,"热点参数限流,请稍后再试!"),
        /**系统规则不满足**/
        RC203(203,"系统规则不满足要求,请稍后再试!"),
        /**授权规则不通过**/
        RC204(204,"授权规则不通过,请稍后再试!"),
        /**access_denied**/
        RC403(403,"无访问权限,请联系管理员授予权限"),
        /**access_denied**/
        RC401(401,"匿名用户访问无权限资源时的异常"),
        /**服务异常**/
        RC500(500,"系统异常，请稍后重试"),

        INVALID_TOKEN(2001,"访问令牌不合法"),
        ACCESS_DENIED(2003,"没有权限访问该资源"),
        CLIENT_AUTHENTICATION_FAILED(1001,"客户端认证失败"),
        USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误"),
        UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");

        /**自定义状态码**/
        private final int status;
        /**自定义描述**/
        private final String message;

        ReturnCode(int status, String message){
            this.status = status;
            this.message = message;
        }

    }
}
