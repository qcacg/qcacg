package com.qcacg.service.system;

import com.qcacg.entity.ContentEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public interface ContentService extends BaseService<ContentEntity> {

    public ContentEntity findContentByVolumeId(Long volumeId);

    public void saveOrUpdate(ContentEntity contentEntity);

    public ContentEntity findContentByContentId(Long contentId);

    public List<ContentEntity> findContentByBookId(Long bookId);

    public void updateContentStatus(Long contentId);

    public void delete(Long contentId);

    public void updateContent(ContentEntity contentEntity);

}
