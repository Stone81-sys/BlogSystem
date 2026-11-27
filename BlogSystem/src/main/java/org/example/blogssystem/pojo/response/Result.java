package org.example.blogssystem.pojo.response;

import lombok.Data;
import org.example.blogssystem.common.enums.ResultEnums;

@Data
public class Result<T> {
    public int code;
    public T data;
    public String message;

    public static <T> Result success(T data){
        Result result =new Result<>();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setData(data);
        return result;

    }
    public static Result fail(String message){
        Result result =new Result<>();
        result.setCode(ResultEnums.FAIL.getCode());
        result.setMessage(message);
        return result;
    }

}
