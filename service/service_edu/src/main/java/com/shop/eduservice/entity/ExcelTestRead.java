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
public class ExcelTestRead {
    @ExcelProperty(value = "i姓名", index = 0)
    private String name;
    @ExcelProperty(value = "nicheng", index = 1)
    private String name2;
}
