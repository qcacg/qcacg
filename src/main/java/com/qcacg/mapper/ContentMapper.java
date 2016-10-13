package com.qcacg.mapper;

import com.qcacg.entity.ContentEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ContentMapper extends Mapper<ContentEntity>{

    public ContentEntity findContentByVolumeId(Long volumeId);

    public ContentEntity findContentByContentId(Long contentId);

    public List<ContentEntity> findContentByBookId(Long bookId);

    public void updateContentStatus(Long contentId);

    public void updateContent(ContentEntity contentEntity);
}