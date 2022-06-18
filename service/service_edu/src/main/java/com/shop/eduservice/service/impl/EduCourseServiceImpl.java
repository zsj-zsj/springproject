package com.shop.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.eduservice.entity.EduCourse;
import com.shop.eduservice.entity.EduCourseDescription;
import com.shop.eduservice.mapper.EduCourseMapper;
import com.shop.eduservice.service.EduChapterService;
import com.shop.eduservice.service.EduCourseDescriptionService;
import com.shop.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.eduservice.service.EduVideoService;
import com.shop.eduservice.vo.CourseInfoDataVO;
import com.shop.eduservice.vo.CourseInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Autowired
    private EduChapterService eduChapterService;
    @Autowired
    private EduVideoService eduVideoService;

    @Override
    @Transactional
    public int addCourse(CourseInfoVO courseInfoVO) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVO,eduCourse);
        baseMapper.insert(eduCourse);

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setCourseId(eduCourse.getId());
        eduCourseDescription.setDescription(courseInfoVO.getDescription());
        eduCourseDescriptionService.save(eduCourseDescription);
        return 1;
    }

    @Override
    public CourseInfoVO getCourseInfo(Integer id) {
        EduCourse eduCourse = baseMapper.selectById(id);
        CourseInfoVO courseInfoVO = new CourseInfoVO();
        BeanUtils.copyProperties(eduCourse,courseInfoVO);

        QueryWrapper<EduCourseDescription> eduCourseDescriptionQueryWrapper = new QueryWrapper<>();
        eduCourseDescriptionQueryWrapper.eq("course_id",id);
        EduCourseDescription one = eduCourseDescriptionService.getOne(eduCourseDescriptionQueryWrapper);
        courseInfoVO.setDescription(one.getDescription());
        return courseInfoVO;
    }

    @Override
    @Transactional
    public int editCourse(Integer id,CourseInfoVO courseInfoVO) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        BeanUtils.copyProperties(courseInfoVO,eduCourse);
        int i = baseMapper.updateById(eduCourse);

        QueryWrapper<EduCourseDescription> wrapper = new QueryWrapper<>();
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVO.getDescription());
        wrapper.eq("course_id",id);
        eduCourseDescriptionService.update(eduCourseDescription,wrapper);
        return 1;
    }

    @Override
    public CourseInfoDataVO courseInfo(Integer id) {
        return baseMapper.courseInfoData(id);
    }

    @Override
    @Transactional
    public int deleteCoures(Integer id) {
        baseMapper.deleteById(id);
        eduCourseDescriptionService.deleteCourseInfo(id);
        eduChapterService.deleteCourseInfo(id);
        eduVideoService.deleteCourseInfo(id);
        return 1;
    }
}
