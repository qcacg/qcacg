package com.qcacg.service.system.impl;

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

    public String saveOrUpdate(VolumeEntity entity) {
        String result = "";
        try
        {
            if (entity.getVolumeId() == null)
            {
                return this.save(entity);
            } else
            {
                result = this.update(entity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public List<VolumeEntity> findVolumeByBookId(Long bookId) {
        return this.volumeMapper.findVolumeByBookId(bookId);
    }
}
