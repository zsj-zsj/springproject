package com.shop.eduservice.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CourseInfoDataVO {
    private Integer id;
    private String title;
    private String subjectOne;
    private String subjectTwo;
    private String teacherName;
    private String description;
    private Integer lessonNum;
    private String cover;
    private BigDecimal price;
}
