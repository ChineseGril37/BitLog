package org.lengs.bitlogserver.common;

import lombok.Getter;

/**
 * @Author: lengs
 * @Date: 2024/6/2 13:31
 * @Description:
 * @Version: 1.0
 */
@Getter
public enum ResultCode {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    WRONG_INPUT(400, "输入有误！"),
    AUTH_ERROR(502, "授权失败!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),
    DATABASE_OPERATION_FAILED(504, "数据库操作失败");
    private final int status;
    private final String message;
    ResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
