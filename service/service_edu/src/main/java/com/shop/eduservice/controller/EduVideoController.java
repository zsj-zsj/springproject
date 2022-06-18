package com.shop.eduservice.controller;


import com.shop.eduservice.entity.EduChapter;
import com.shop.eduservice.entity.EduVideo;
import com.shop.eduservice.service.EduVideoService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/eduservice/eduVideo")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @PostMapping("addVideo")
    public Result addVideo(@RequestBody EduVideo eduVideo){
        return Result.success().data("data",eduVideoService.save(eduVideo));
    }

    @PostMapping("editVideo")
    public Result editVideo(@RequestBody EduVideo eduVideo){
        return Result.success().data("data",eduVideoService.updateById(eduVideo));
    }

}

