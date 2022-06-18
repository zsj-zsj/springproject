package com.shop.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.eduservice.entity.EduCourse;
import com.shop.eduservice.entity.EduTeacher;
import com.shop.eduservice.service.EduCourseService;
import com.shop.eduservice.vo.CourseInfoVO;
import com.shop.eduservice.vo.PageFunction;
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
@RequestMapping("/eduservice/eduCourse")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("courseList")
    public Result courseList(PageFunction page, @RequestBody EduCourse eduCourse){
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        Page<EduCourse> eduCoursePage = new Page<>(page.getCurrentPage(),page.getCurrentLimit());
        eduCourseService.page(eduCoursePage,wrapper);
        List<EduCourse> records = eduCoursePage.getRecords();
        return Result.success().data("data",records);
    }

    @PostMapping("addCourse")
    public Result addCourse(@RequestBody CourseInfoVO courseInfoVO){
        int i = eduCourseService.addCourse(courseInfoVO);
        return Result.success().data("id",i);
    }

    @GetMapping("getCourseInfo/{id}")
    public Result getCourseInfo(@PathVariable Integer id){
        CourseInfoVO courseInfoVO = eduCourseService.getCourseInfo(id);
        return Result.success().data("data",courseInfoVO);
    }

    @PutMapping("editCourse/{id}")
    public Result editCourse(@PathVariable Integer id,@RequestBody CourseInfoVO courseInfoVO){
        int i = eduCourseService.editCourse(id,courseInfoVO);
        return Result.success().data("id",i);
    }

    @GetMapping("courseInfo/{id}")
    public Result courseInfo(@PathVariable Integer id){
        return Result.success().data("data",eduCourseService.courseInfo(id));
    }

    @DeleteMapping("deleteCoures/{id}")
    public Result deleteCoures(@PathVariable Integer id){
        return Result.success().data("data",eduCourseService.deleteCoures(id));
    }


}

