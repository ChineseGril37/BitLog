package org.lengs.bblogserver.common;

import lombok.Data;

/**
 * @author lengs
 */
@Data
public class Result {
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 100;
    private int code;
    private String msg;
    private Object data;
    public static Result success(){
        Result result =new Result();
        result.code = SUCCESS_CODE;
        return result;
    }
    public static Result success(Object data){
        Result result =new Result();
        result.data = data;
        result.code = SUCCESS_CODE;
        return result;
    }
    public static Result success(String msg){
        Result result =new Result();
        result.msg = msg;
        result.code = SUCCESS_CODE;
        return result;
    }
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
}
