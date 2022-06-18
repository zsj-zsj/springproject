package com.shop.eduservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneSubjectTree {

    private Integer id;
    private String title;

    private List<TwoSubjectTree> children = new ArrayList<>();

}
