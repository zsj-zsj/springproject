package com.shop.eduservice.vo;


import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class EduTeacherVO implements Serializable {

    private String name;

}
