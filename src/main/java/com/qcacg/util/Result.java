package com.qcacg.util;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/22.
 */

public class Result {


    public ArrayList<String> avatarUrls;

    public String sourceUrl;

    public String userid;

    public String username;

    private String msg;

    private String code;

    private boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(ArrayList<String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
