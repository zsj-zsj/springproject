package com.shop.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.eduservice.dto.EduSubjectExcelDTO;
import com.shop.eduservice.dto.OneSubjectTree;
import com.shop.eduservice.dto.TwoSubjectTree;
import com.shop.eduservice.entity.EduSubject;
import com.shop.eduservice.listen.EduSubjectExcelListen;
import com.shop.eduservice.mapper.EduSubjectMapper;
import com.shop.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OneSubjectTree> getAllSubject() {

        QueryWrapper<EduSubject> wrapperPanents = new QueryWrapper<>();
        wrapperPanents.eq("parent_id",0);
        List<EduSubject> eduSubjects = baseMapper.selectList(wrapperPanents);

        QueryWrapper<EduSubject> wrapperChildren = new QueryWrapper<>();
        wrapperChildren.ne("parent_id",0);
        List<EduSubject> chidren = baseMapper.selectList(wrapperChildren);

        List<OneSubjectTree> oneSubject = new ArrayList<>();

        for (int i = 0; i < eduSubjects.size(); i++) {
            EduSubject eduSubject = eduSubjects.get(i);
            OneSubjectTree oneSubjectTree = new OneSubjectTree();
            BeanUtils.copyProperties(eduSubject,oneSubjectTree);
            oneSubject.add(oneSubjectTree);

            ArrayList<TwoSubjectTree> twoSubjectTrees = new ArrayList<>();
            for (int j = 0; j < chidren.size(); j++) {
                EduSubject eduSubjecttwo  = chidren.get(j);
                if(eduSubjecttwo.getParentId().equals(eduSubject.getId())){
                    TwoSubjectTree twoSubjectTree = new TwoSubjectTree();
                    BeanUtils.copyProperties(eduSubjecttwo,twoSubjectTree);
                    twoSubjectTrees.add(twoSubjectTree);
                }
            }
            oneSubjectTree.setChildren(twoSubjectTrees);
        }
        return oneSubject;

    }

    /*
            oneSubjectTree.setId(eduSubject.getId());
            oneSubjectTree.setTitle(eduSubject.getTitle());
            上面两行可以写成下面的一行
            BeanUtils.copyProperties(eduSubject,oneSubjectTree);
     */
}
