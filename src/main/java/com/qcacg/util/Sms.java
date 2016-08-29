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
        String url="http://gw.api.taobao.com/router/rest";
        TaobaoClient client = new DefaultTaobaoClient(url, "23443437", "d952c9b7409dfe772b6f0e19e775e689");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("轻创轻小说");
        req.setSmsParam("{\"number\":\""+telephoneCode+"\",\"product\":\"轻创轻小说\"}");
        req.setRecNum(telephone);
        req.setSmsTemplateCode("SMS_13700646");
        AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
        System.out.println(response.getBody());
    }
}
