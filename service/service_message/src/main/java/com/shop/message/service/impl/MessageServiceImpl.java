package com.shop.message.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.shop.message.service.MessageService;
import org.springframework.util.StringUtils;

import java.util.Map;

public class MessageServiceImpl implements MessageService {

    @Override
    public Boolean sendMessage(Map<String, Object> code, String mobile) {
        if (StringUtils.isEmpty(mobile)) return false;
        DefaultProfile profile = DefaultProfile.getProfile("default", "accessKeyId", "secret");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("PhoneNumbers", mobile);//设置手机号
        request.putQueryParameter("SignName", "value");//短信服务 国内消息 签名管理 签名名称
        request.putQueryParameter("TemplateCode", "value");//短信服务 国内消息 签名管理 模板CODE
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
