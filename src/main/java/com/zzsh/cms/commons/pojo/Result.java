package com.zzsh.cms.commons.pojo;
/**
 * @program: cms
 * @description: 通用操作结果对象
 * @author: PengBowen
 * @create: 2018-05-24 22:27
 **/

/**
 * @program: cms
 *
 * @description: 通用操作结果对象
 *
 * @author: 彭博文
 *
 * @create: 2018-05-24 22:27
 **/
public class Result<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public static Result SUCCESS = new Result(200,"ok",null);

    public static Result FAIL = new Result(403,"操作失败",null);

    public static Result ERROR = new Result(500,"系统错误!",null);




    /**
     * 构造方法
     * @param code
     * @param message
     * @param data
     */
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
