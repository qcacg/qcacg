package com.qcacg.entity.user;

import com.qcacg.entity.UserEntity;

/**
 * Created by Administrator on 2016/6/17.
 * 用户信息扩展类，一般不直接用逆向工程生成类
 */
public class UserCustom extends UserEntity{



    private String passWordConfirm;

    public String getPassWordConfirm() {
        return passWordConfirm;
    }

    public void setPassWordConfirm(String passWordConfirm) {
        this.passWordConfirm = passWordConfirm;
    }



}
