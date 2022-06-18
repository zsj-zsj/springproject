package com.shop.eduservice.controller;


import com.shop.eduservice.dto.OneSubjectTree;
import com.shop.eduservice.service.EduSubjectService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/eduservice/eduSubject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("addSubject")
    public void addSubject(MultipartFile file) throws IOException {
        eduSubjectService.addSubject(file,eduSubjectService);
    }

    @GetMapping("getAllSubject")
    public Result getAllSubject(){
        List<OneSubjectTree> allSubject = eduSubjectService.getAllSubject();
        return Result.success().data("data",allSubject);
    }

}

