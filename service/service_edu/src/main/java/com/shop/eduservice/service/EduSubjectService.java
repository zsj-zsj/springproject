package com.shop.eduservice.service;

import com.shop.eduservice.dto.OneSubjectTree;
import com.shop.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-16
 */
public interface EduSubjectService extends IService<EduSubject> {

    void addSubject(MultipartFile file,EduSubjectService eduSubjectService) throws IOException;

    List<OneSubjectTree> getAllSubject();
}
