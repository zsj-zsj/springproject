package com.shop.eduservice.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-13
 */
@Data
public class Excel  {

    @ExcelProperty("姓名")
    private String candidateName;

    @ExcelProperty("考生编号")
    private String candidateNo;

    @ExcelProperty("拟录取专业代码")
    private String majorCode;

    @ExcelProperty("拟录取专业名称")
    private String majorName;

    @ExcelProperty("专业研究方向")
    private String category;

    @ExcelProperty("初试成绩")
    private String firstFraction;

    @ExcelProperty("复试成绩")
    private String retestFraction;

    @ExcelProperty("拟录取总成绩")
    private String totalFraction;

    @ExcelProperty("备注")
    private String remarks;

}
