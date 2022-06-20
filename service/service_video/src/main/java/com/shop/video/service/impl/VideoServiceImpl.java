package com.shop.video.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.shop.utils.Result;
import com.shop.video.service.VideoService;
import com.shop.video.utils.AliyunVideoInit;
import com.shop.video.utils.ConstantVideoUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public String uploadAliyunVideo(MultipartFile file){
        try{
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String title = fileName.substring(0,fileName.lastIndexOf("."));
            UploadStreamRequest request = new UploadStreamRequest(ConstantVideoUtils.KEY_ID, ConstantVideoUtils.KEY_SECRET, title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = "";
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
            return videoId;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteBatchVideo(List ids) throws Exception {
        String idsString = StringUtils.join(ids.toArray(), ",");
        DefaultAcsClient client = AliyunVideoInit.aliyunVideoInit(ConstantVideoUtils.KEY_ID, ConstantVideoUtils.KEY_SECRET);
        DeleteVideoRequest deleteVideoRequest = new DeleteVideoRequest();
        deleteVideoRequest.setVideoIds(idsString);
        client.doAction(deleteVideoRequest);
    }

    @Override
    public String getPlayAuth(String vid) throws Exception {
        DefaultAcsClient client = AliyunVideoInit.aliyunVideoInit(ConstantVideoUtils.KEY_ID, ConstantVideoUtils.KEY_SECRET);
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(vid);
        GetVideoPlayAuthResponse acsResponse = client.getAcsResponse(request);
        String playAuth = acsResponse.getPlayAuth();
        return playAuth;
    }
}
