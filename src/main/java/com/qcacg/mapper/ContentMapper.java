package com.qcacg.mapper;

import com.qcacg.entity.ContentEntity;
import tk.mybatis.mapper.common.Mapper;

public interface ContentMapper extends Mapper<ContentEntity>{
    public ContentEntity findContentByChapterId(Long chapterId);
}