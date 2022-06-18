package com.shop.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.eduservice.entity.EduChapter;
import com.shop.eduservice.entity.EduCourseDescription;
import com.shop.eduservice.entity.EduVideo;
import com.shop.eduservice.mapper.EduChapterMapper;
import com.shop.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.eduservice.service.EduVideoService;
import com.shop.eduservice.vo.ChapterVO;
import com.shop.eduservice.vo.VideoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-18
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVO> chapterList(Integer id) {
        QueryWrapper<EduChapter> eduChapterQueryWrapper = new QueryWrapper<>();
        eduChapterQueryWrapper.eq("course_id",id);
        List<EduChapter> eduChapters = baseMapper.selectList(eduChapterQueryWrapper);

        QueryWrapper<EduVideo> eduVideoQueryWrapper  = new QueryWrapper<>();
        eduVideoQueryWrapper.eq("course_id",id);
        List<EduVideo> eduVideo = eduVideoService.list(eduVideoQueryWrapper);

        ArrayList<ChapterVO> chapterVOS = new ArrayList<>();

        for (int i = 0; i < eduChapters.size(); i++) {
            EduChapter eduChapter = eduChapters.get(i);
            ChapterVO chapterVO = new ChapterVO();
            BeanUtils.copyProperties(eduChapter,chapterVO);
            chapterVOS.add(chapterVO);
            ArrayList<VideoVO> videoVOArrayList = new ArrayList<>();
            for (int j = 0; j < eduVideo.size(); j++) {
                EduVideo video = eduVideo.get(j);
                if(eduChapter.getId().equals(video.getChapterId())){
                    VideoVO videoVO = new VideoVO();
                    BeanUtils.copyProperties(video,videoVO);
                    videoVOArrayList.add(videoVO);
                }
            }
            chapterVO.setChildren(videoVOArrayList);
        }
        return chapterVOS;
    }

    @Override
    @Transactional
    public int deleteChapter(Integer id) {
        baseMapper.deleteById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("chapter_id",id);
        eduVideoService.removeByMap(map);
        return 1;
    }

    @Override
    public int deleteCourseInfo(Integer id) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",id);
        return baseMapper.delete(wrapper);
    }
}
