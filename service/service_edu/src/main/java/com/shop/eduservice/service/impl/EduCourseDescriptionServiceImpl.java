package com.shop.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.eduservice.entity.EduCourseDescription;
import com.shop.eduservice.mapper.EduCourseDescriptionMapper;
import com.shop.eduservice.service.EduCourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@Service
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription> implements EduCourseDescriptionService {

    @Override
    public int deleteCourseInfo(Integer id) {
        QueryWrapper<EduCourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",id);
        return baseMapper.delete(wrapper);
    }
}
