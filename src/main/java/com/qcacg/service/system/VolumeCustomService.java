package com.qcacg.service.system;

import com.qcacg.entity.ContentEntity;
import com.qcacg.entity.volume.VolumeCustom;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public interface VolumeCustomService {
    public List<VolumeCustom> findVolumeAndContentByBookId(Long bookId);

    public List<ContentEntity> findContentByVolumeIdAndBookId(Long bookId);
}
