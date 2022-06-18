package com.shop.eduservice.service;

import com.shop.eduservice.entity.EduCourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
public interface EduCourseDescriptionService extends IService<EduCourseDescription> {

    int deleteCourseInfo(Integer id);
}
