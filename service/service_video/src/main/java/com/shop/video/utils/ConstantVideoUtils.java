package com.shop.video.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantVideoUtils implements InitializingBean {

    @Value("${aliyun.video.keyid}")
    private String keyid;
    @Value("${aliyun.video.keysecret}")
    private String keysecret;

    public static String KEY_ID;
    public static String KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = keyid;
        KEY_SECRET = keysecret;
    }
}
