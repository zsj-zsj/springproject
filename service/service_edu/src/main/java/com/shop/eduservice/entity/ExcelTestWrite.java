package com.shop.eduservice.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-13
 */
@Data
public class ExcelTestWrite {
    @ExcelProperty("i姓名")
    private String name;
    @ExcelProperty("nicheng")
    private String name2;
}
