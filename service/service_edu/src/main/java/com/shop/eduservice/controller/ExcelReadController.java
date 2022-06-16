package com.shop.eduservice.controller;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.shop.eduservice.entity.EduTeacher;
import com.shop.eduservice.entity.ExcelTestRead;
import com.shop.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ExcelReadController extends AnalysisEventListener<ExcelTestRead> {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Override
    public void invoke(ExcelTestRead excelTestRead, AnalysisContext analysisContext) {
        System.out.println("****"+excelTestRead);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头"+headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

