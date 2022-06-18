package com.shop.eduservice.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.shop.eduservice.entity.EduChapter;
import com.shop.eduservice.service.EduChapterService;
import com.shop.eduservice.vo.ChapterVO;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/eduservice/eduChapter")
public class EduChapterController {


    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("chapterList/{courseId}")
    public Result chapterList(@PathVariable Integer courseId){
        List<ChapterVO> res = eduChapterService.chapterList(courseId);
        return Result.success().data("data",res);
    }


    @PostMapping("addChapter")
    public Result addChapter(@RequestBody EduChapter eduChapter){
        return Result.success().data("data",eduChapterService.save(eduChapter));
    }

    @PutMapping("updChapter/{id}")
    public Result updChapter(@PathVariable Integer id, @RequestBody EduChapter eduChapter){
        eduChapter.setId(id);
        return Result.success().data("data",eduChapterService.updateById(eduChapter));
    }

    @DeleteMapping("deleteChapter/{id}")
    public Result deleteChapter(@PathVariable Integer id){
        eduChapterService.deleteChapter(id);
        return Result.success();
    }
}

