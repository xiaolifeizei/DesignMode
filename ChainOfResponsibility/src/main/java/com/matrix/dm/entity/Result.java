package com.matrix.dm.entity;

import lombok.Data;

/**
 * 返回结果
 *
 * @author : cui_feng
 * @since : 2022-12-27 09:41
 */
@Data
public class Result {

    private String msg;

    private Integer code;

    private Boolean success = false;

    public static Result failure(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(500);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    public Boolean isSuccess() {
        return success;
    }
}
