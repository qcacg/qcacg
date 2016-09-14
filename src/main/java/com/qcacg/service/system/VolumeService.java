package com.qcacg.service.system;

import com.qcacg.entity.ContentEntity;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public interface VolumeService extends BaseService<VolumeEntity> {

    public String saveOrUpdate(VolumeEntity entity);

    public List<VolumeEntity> findVolumeByBookId(Long bookId);

    public List<ContentEntity> findVolumeAndContentByBookId(Long bookId);
}
