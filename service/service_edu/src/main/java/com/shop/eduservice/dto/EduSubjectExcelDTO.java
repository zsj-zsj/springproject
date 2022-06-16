package com.shop.eduservice.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EduSubjectExcelDTO {

    @ExcelProperty(value = "名称" ,index = 0)
    private String title;

}
