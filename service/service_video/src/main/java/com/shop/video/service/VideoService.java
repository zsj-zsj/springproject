package com.shop.video.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {

    String uploadAliyunVideo(MultipartFile file) throws IOException;

    void deleteBatchVideo(List ids) throws Exception;
}
