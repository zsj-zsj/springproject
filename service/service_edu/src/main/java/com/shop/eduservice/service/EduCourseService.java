package com.shop.eduservice.service;

import com.shop.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.eduservice.vo.CourseInfoDataVO;
import com.shop.eduservice.vo.CourseInfoVO;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
public interface EduCourseService extends IService<EduCourse> {

    int addCourse(CourseInfoVO courseInfoVO);

    CourseInfoVO getCourseInfo(Integer id);

    int editCourse(Integer id,CourseInfoVO courseInfoVO);

    CourseInfoDataVO courseInfo(Integer id);

    int deleteCoures(Integer id);
}
