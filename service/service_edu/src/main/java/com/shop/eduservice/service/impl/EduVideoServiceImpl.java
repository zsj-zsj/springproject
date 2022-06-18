package com.shop.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.eduservice.entity.EduChapter;
import com.shop.eduservice.entity.EduVideo;
import com.shop.eduservice.mapper.EduVideoMapper;
import com.shop.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Override
    public int deleteCourseInfo(Integer id) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",id);
        return baseMapper.delete(wrapper);
    }
}
