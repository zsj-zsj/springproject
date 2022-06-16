package com.shop.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    String uploadOssDo(MultipartFile file);

}
