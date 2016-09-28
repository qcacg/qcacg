package com.qcacg.service.system.impl;

import com.qcacg.entity.ContentEntity;
import com.qcacg.entity.volume.VolumeCustom;
import com.qcacg.mapper.VolumeCustomMapper;
import com.qcacg.service.system.VolumeCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Service
public class VolumeCustomServiceImpl implements VolumeCustomService{

    @Autowired
    VolumeCustomMapper volumeCustomMapper;
    @Override
    public List<VolumeCustom> findVolumeAndContentByBookId(Long bookId) {

        return this.volumeCustomMapper.findVolumeAndContentByBookId(bookId);
    }

    @Override
    public List<ContentEntity> findContentByVolumeIdAndBookId(Long bookId) {
        return this.volumeCustomMapper.findContentByVolumeIdAndBookId(bookId);
    }
}
