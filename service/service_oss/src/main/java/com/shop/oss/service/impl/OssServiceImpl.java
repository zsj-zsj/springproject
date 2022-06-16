package com.shop.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.shop.oss.service.OssService;
import com.shop.oss.utils.AliyunOssUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {


    @Override
    public String uploadOssDo(MultipartFile file) {
        String endpoint = AliyunOssUtils.END_POINT;
        String accessKeyId = AliyunOssUtils.KEY_ID;
        String accessKeySecret = AliyunOssUtils.KEY_SECRET;
        String bucketName = AliyunOssUtils.BUCKET_NAME;
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            InputStream inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replace("-","");
            String datePath = new DateTime().toString("yyyy/MM/dd");
            fileName = datePath+"/"+uuid+fileName;

            ossClient.putObject(bucketName, fileName, inputStream);
            ossClient.shutdown();
            String url = "";
            url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
