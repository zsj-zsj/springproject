package com.shop.eduservice.controller;


import com.shop.eduservice.client.ServiceVideoClient;
import com.shop.eduservice.entity.EduChapter;
import com.shop.eduservice.entity.EduVideo;
import com.shop.eduservice.service.EduVideoService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    //注入 微服务接口
    @Autowired
    private ServiceVideoClient serviceVideoClient;

    @PostMapping("addVideo")
    public Result addVideo(@RequestBody EduVideo eduVideo){
        return Result.success().data("data",eduVideoService.save(eduVideo));
    }

    @PostMapping("editVideo")
    public Result editVideo(@RequestBody EduVideo eduVideo){
        return Result.success().data("data",eduVideoService.updateById(eduVideo));
    }

    @DeleteMapping("deleteVideo/{id}")
    public Result deleteVideo(@PathVariable Integer id){
        EduVideo byId = eduVideoService.getById(id);
        String videoSourceId = byId.getVideoSourceId();
        boolean resDelete = eduVideoService.removeById(id);
        if (resDelete){
            if(videoSourceId != null){
                Result result = serviceVideoClient.uploadAliyunVideo(videoSourceId);
                if (result.getCode() == 20001){
                    return result;
                }
            }
        }
        return Result.success();
    }

}

