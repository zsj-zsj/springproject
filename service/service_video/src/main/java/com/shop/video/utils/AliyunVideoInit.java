package com.shop.video.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

public class AliyunVideoInit {

    public static DefaultAcsClient aliyunVideoInit(String key, String secrey)  throws Exception{
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, key, secrey);
        DefaultAcsClient defaultAcsClient = new DefaultAcsClient(profile);
        return defaultAcsClient;
    }

}
