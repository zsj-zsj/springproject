package com.shop.eduservice.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVO {

    private Integer id;
    private String title;

    private List<VideoVO> children = new ArrayList<>();


}
