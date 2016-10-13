package com.qcacg.service.system.impl;

import com.qcacg.entity.ContentEntity;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.mapper.VolumeMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
@Service
public class VolumeServiceImpl extends BaseServiceImpl<VolumeEntity> implements VolumeService {

    @Autowired
    VolumeMapper volumeMapper;

    public void saveOrUpdate(VolumeEntity entity) {

        try
        {
            if (entity.getVolumeId() == null)
            {
                 this.save(entity);
            } else
            {
                 this.updateVolume(entity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    @Override
    public List<VolumeEntity> findVolumeByBookId(Long bookId) {
        return this.volumeMapper.findVolumeByBookId(bookId);
    }

    @Override
    public void delete(Long volumeId) {
        this.volumeMapper.deleteByPrimaryKey(volumeId);
    }

    @Override
    public void updateVolume(VolumeEntity volumeEntity) {
        this.volumeMapper.updateVolume(volumeEntity);
    }


}
