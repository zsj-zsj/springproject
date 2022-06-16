package com.shop.oss.controller;

import com.shop.oss.service.OssService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("oss")
@RestController
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;


    @PostMapping("ossFile")
    public Result ossFile(MultipartFile file){
        return Result.success().data("url",ossService.uploadOssDo(file));
    }

}
