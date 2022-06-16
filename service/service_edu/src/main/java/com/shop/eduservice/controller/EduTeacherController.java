package com.shop.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.eduservice.vo.EduTeacherVO;
import com.shop.eduservice.vo.PageFunction;
import com.shop.eduservice.entity.EduTeacher;
import com.shop.eduservice.service.EduTeacherService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-13
 */
@RestController
@RequestMapping("/eduservice/eduTeacher")
@CrossOrigin
public class EduTeacherController {


    @Autowired
    private EduTeacherService eduTeacherService;

    @PostMapping("teacherList" )
    public Result teacherList(PageFunction page, @RequestBody(required = false) EduTeacherVO eduTeacherVO){
        QueryWrapper<EduTeacher> eduTeacherQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(eduTeacherVO.getName())){
            eduTeacherQueryWrapper.like("name",eduTeacherVO.getName());
        }
        Page<EduTeacher> teacherPage = new Page<>(page.getCurrentPage(),page.getCurrentLimit());
        eduTeacherService.page(teacherPage,eduTeacherQueryWrapper);
        List<EduTeacher> records = teacherPage.getRecords();
        return Result.success().data("data",records).data("total",teacherPage.getTotal());
    }

    @DeleteMapping("deleteTeacher/{id}")
    public Result deleteTeacher(@PathVariable Integer id){
        return Result.success().data("data",eduTeacherService.removeById(id));
    }

    @PostMapping("createTeacher")
    public Result createTeacher(@RequestBody EduTeacher eduTeacher){
        return Result.success().data("data",eduTeacherService.save(eduTeacher));
    }

    @PutMapping("updateTeacher/{id}")
    public Result updateTeacher(@PathVariable Integer id, @RequestBody EduTeacher eduTeacher){
        eduTeacher.setId(id);
        return Result.success().data("data",eduTeacherService.updateById(eduTeacher));
    }

    @GetMapping("teacherInfo/{id}")
    public Result teacherInfo(@PathVariable Integer id){
        return Result.success().data("data",eduTeacherService.getById(id));
    }
}

