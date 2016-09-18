package com.qcacg.mapper;

import com.qcacg.entity.VolumeEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VolumeMapper extends Mapper<VolumeEntity> {

    public List<VolumeEntity> findVolumeByBookId(Long bookId);




}