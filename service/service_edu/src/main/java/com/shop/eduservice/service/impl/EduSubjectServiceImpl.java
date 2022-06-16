package com.shop.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.shop.eduservice.dto.EduSubjectExcelDTO;
import com.shop.eduservice.entity.EduSubject;
import com.shop.eduservice.listen.EduSubjectExcelListen;
import com.shop.eduservice.mapper.EduSubjectMapper;
import com.shop.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-16
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void addSubject(MultipartFile file,EduSubjectService eduSubjectService) throws IOException {
        InputStream inputStream = file.getInputStream();

        EasyExcel.read(inputStream, EduSubjectExcelDTO.class, new EduSubjectExcelListen(eduSubjectService)).sheet().doRead();


    }
}
