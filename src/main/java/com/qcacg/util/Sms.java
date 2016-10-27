package com.qcacg.util;
/**
 * Created by Administrator on 2016/8/28.
 */

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class Sms {

    public static void sendMessage(String telephone, StringBuilder telephoneCode) throws ApiException {

        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23454250", "1b31945a443c43e6c4caaf22a09d0f5c");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("注册验证");
        req.setSmsParam("{\"code\":\""+telephoneCode+"\",\"product\":\"轻悦轻小说\"}");
        req.setRecNum(telephone);
        req.setSmsTemplateCode("SMS_14715820");
        AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
        System.out.println(response.getBody());
    }
}
