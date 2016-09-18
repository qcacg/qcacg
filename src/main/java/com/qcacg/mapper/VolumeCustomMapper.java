package com.qcacg.mapper;

import com.qcacg.entity.volume.VolumeCustom;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public interface VolumeCustomMapper {

    public List<VolumeCustom> findVolumeAndContentByBookId(Long bookId);
}
