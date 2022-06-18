package com.shop.eduservice.mapper;

import com.shop.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.eduservice.vo.CourseInfoDataVO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@Repository
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    public CourseInfoDataVO courseInfoData(Integer id);

}
