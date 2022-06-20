package com.shop.user.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WechatOauthUtils implements InitializingBean {

    @Value("${wechat.open.appid}")
    private String appid;

    @Value("${wechat.open.appsecret}")
    private String appsecret;

    @Value("${wechat.open.redirecturl}")
    private String redirecturl;


    public static String APP_ID;
    public static String APP_SECRET;
    public static String REDIRECT_URL;

    @Override
    public void afterPropertiesSet() throws Exception {
        APP_ID = appid;
        APP_SECRET = appsecret;
        REDIRECT_URL = redirecturl;
    }
}
