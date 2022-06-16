package com.shop.eduservice.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.shop.eduservice.dto.EduSubjectExcelDTO;
import com.shop.eduservice.entity.EduSubject;
import com.shop.eduservice.service.EduSubjectService;

public class EduSubjectExcelListen extends AnalysisEventListener<EduSubjectExcelDTO> {
//    监听不能交给spring注入
    public EduSubjectService eduSubjectService;
    public EduSubjectExcelListen() {
    }
    public EduSubjectExcelListen(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(EduSubjectExcelDTO eduSubjectExcelDTO, AnalysisContext analysisContext) {
        if(eduSubjectExcelDTO == null){
            return;
        }
        EduSubject eduSubject = new EduSubject();
        eduSubject.setTitle(eduSubjectExcelDTO.getTitle());
        eduSubjectService.save(eduSubject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
