package com.qcacg.entity.volume;

import com.qcacg.entity.ContentEntity;
import com.qcacg.entity.VolumeEntity;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
public class VolumeCustom extends VolumeEntity{

    @Transient
    private List<ContentEntity> contentEntityList;

    public List<ContentEntity> getContentEntityList() {
        return contentEntityList;
    }

    public void setContentEntityList(List<ContentEntity> contentEntityList) {
        this.contentEntityList = contentEntityList;
    }
}
