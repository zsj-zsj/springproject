package com.shop.eduservice.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageFunction implements Serializable {

    private Integer currentPage;
    private Integer currentLimit;

}
