package com.shop.video.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.baomidou.mybatisplus.extension.api.R;
import com.shop.utils.Result;
import com.shop.video.service.VideoService;
import com.shop.video.utils.AliyunVideoInit;
import com.shop.video.utils.ConstantVideoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("eduservice/eduvideo")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("uploadAliyunVideo")
    public Result uploadAliyunVideo(MultipartFile file) throws IOException {
        String id = videoService.uploadAliyunVideo(file);
        return Result.success().data("data",id);
    }

    @DeleteMapping("deleteAliyunVideo/{vid}")
    public Result uploadAliyunVideo(@PathVariable String vid) throws Exception {
        DefaultAcsClient client = AliyunVideoInit.aliyunVideoInit(ConstantVideoUtils.KEY_ID, ConstantVideoUtils.KEY_SECRET);
        DeleteVideoRequest deleteVideoRequest = new DeleteVideoRequest();
        deleteVideoRequest.setVideoIds(vid);
        HttpResponse httpResponse = client.doAction(deleteVideoRequest);
        return Result.success().data("data",httpResponse);
    }

    @DeleteMapping("deleteBatchVideo")
    public Result deleteBatchVideo(@RequestParam("idsList") List idsList) throws Exception {
        videoService.deleteBatchVideo(idsList);
        return Result.success();
    }

}
