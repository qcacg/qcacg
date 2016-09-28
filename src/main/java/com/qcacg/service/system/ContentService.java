package com.qcacg.service.system;

import com.qcacg.entity.ContentEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public interface ContentService extends BaseService<ContentEntity> {

    public ContentEntity findContentByVolumeId(Long volumeId);

    public String saveOrUpdate(ContentEntity entity);

    public ContentEntity findContentByContentId(Long contentId);

    public List<ContentEntity> findContentByBookId(Long bookId);

}
