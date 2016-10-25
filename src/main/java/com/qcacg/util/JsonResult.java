package com.qcacg.util;

import java.io.Serializable;

/**
 * Created by CaiYuanYu on 2016/10/24.
 */
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -3115240322078066434L;
    private final static String SUCCESS = "000001";
    private final static String ERROR = "000002";

    private String status;
    private String message;
    private T data;

    public JsonResult(){}

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
    public JsonResult(String status, String message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
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
