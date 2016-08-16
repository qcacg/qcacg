package com.qcacg.service.system;

import com.qcacg.entity.ChapterEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public interface ChapterService extends BaseService<ChapterEntity> {

    public String saveOrUpdate(ChapterEntity entity);

    public List<ChapterEntity> findChapterByVolumeId(Long VolumeId);
}
