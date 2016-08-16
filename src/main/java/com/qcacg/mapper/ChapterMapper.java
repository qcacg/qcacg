package com.qcacg.mapper;

import com.qcacg.entity.ChapterEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChapterMapper extends Mapper<ChapterEntity> {

    public List<ChapterEntity> findChapterByVolumeId(Long VolumeId);

}