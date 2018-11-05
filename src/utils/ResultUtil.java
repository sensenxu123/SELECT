package utils;

import pojo.Result;

public class ResultUtil {
    private final static Integer SUCCESS_CODE = 200;
    private final static Integer ERROR_CODE = 404;

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);

        return result;
    }

    public static Result success(String msg, Object object) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(msg);
        result.setData(object);

        return result;
    }
}
