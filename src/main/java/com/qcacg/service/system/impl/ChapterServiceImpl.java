package com.qcacg.service.system.impl;

import com.qcacg.entity.ChapterEntity;
import com.qcacg.mapper.ChapterMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
@Service
public class ChapterServiceImpl extends BaseServiceImpl<ChapterEntity> implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    public String saveOrUpdate(ChapterEntity entity) {
        String result = "";
        try
        {
            if (entity.getChapterId() == null)
            {
                return this.save(entity);
            } else
            {
                result = this.update(entity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public List<ChapterEntity> findChapterByVolumeId(Long VolumeId) {
        return this.chapterMapper.findChapterByVolumeId(VolumeId);
    }
}
