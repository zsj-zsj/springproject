package com.shop.eduservice.service;

import com.shop.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
public interface EduVideoService extends IService<EduVideo> {

    int deleteCourseInfo(Integer id);
}
