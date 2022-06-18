package com.shop.eduservice.service;

import com.shop.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.eduservice.vo.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVO> chapterList(Integer id);

    int deleteChapter(Integer id);

    int deleteCourseInfo(Integer id);
}
