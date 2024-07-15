package org.lengs.bitlogserver.common;

import lombok.Getter;

/**
 * @Author: lengs
 * @Date: 2024/6/2 13:31
 * @Description:
 * @Version: 1.0
 */
@Getter
public enum ResultCode{
    AUTHENTICATION_NEEDED(100, "Token过期或无效"),
    TOO_FREQUENT_VISIT(101, "访问太频繁，请休息一会儿"),
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    WRONG_INPUT(400, "输入有误！"),
    FORBIDDEN(404, "禁止访问"),
    AUTH_ERROR(502, "授权失败!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),
    DATABASE_OPERATION_FAILED(504, "数据库操作失败"),
    ARITHMETIC_OPERATION_FAILED(505, "计算异常"),
    ARRAY_INDEX_OUT(506, "数组越界");
    private final int status;
    private final String message;
    ResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
