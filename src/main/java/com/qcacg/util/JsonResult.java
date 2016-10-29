package com.qcacg.util;

import java.io.Serializable;

/**
 * Created by CaiYuanYu on 2016/10/24.
 */
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -3115240322078066434L;
    //表示数据处理成功
    private final static Integer SUCCESS = 1;
    //表示数据处理未成功，当不是异常；可能是参数不符合要求；重名之类。
    private final static Integer ERROR = 0;

    private Integer status;
    private String message;
    private T data;

    public JsonResult(){}

    //直接传入信息，表示未成功。
    public JsonResult(String message, T data) {this(ERROR, message, data);}

    public JsonResult(String message) {
        this(ERROR, message, null);
    }

    public JsonResult(Exception e) {
        this(ERROR, e.getMessage(), null);
    }

    public JsonResult(T data) {
        this(SUCCESS, "", data);
    }

    public JsonResult(Integer status, String message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

}
