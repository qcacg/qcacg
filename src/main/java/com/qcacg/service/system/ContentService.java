package com.qcacg.service.system;

import com.qcacg.entity.ContentEntity;
import com.qcacg.service.BaseService;

/**
 * Created by Administrator on 2016/7/4.
 */
public interface ContentService extends BaseService<ContentEntity> {

//    public List<ContentEntity> findVolumeAndContentByBookId(Long bookId);

    public String saveOrUpdate(ContentEntity entity);

}
