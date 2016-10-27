package com.qcacg.service.system.impl;

import com.qcacg.entity.ContentEntity;
import com.qcacg.mapper.ContentMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.ContentService;
import com.qcacg.util.upload.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
@Service
public class ContentServiceImpl extends BaseServiceImpl<ContentEntity> implements ContentService {

    @Autowired
    ContentMapper contentMapper;


    @Override
    public ContentEntity findContentByVolumeId(Long volumeId) {
        return this.contentMapper.findContentByVolumeId(volumeId);
    }

    @Override
    public void saveOrUpdate(ContentEntity entity) {

        try
        {
            if (entity.getContentId() == null)
            {
                 this.save(entity);

            } else
            {
                  this.updateContent(entity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    @Override
    public ContentEntity findContentByContentId(Long contentId) {
        return this.contentMapper.findContentByContentId(contentId);
    }

    @Override
    public List<ContentEntity> findContentByBookId(Long bookId) {
        return this.contentMapper.findContentByBookId(bookId);
    }

    @Override
    public void updateContentStatus(Long contentId) {
        this.contentMapper.updateContentStatus(contentId);
    }

    @Override
    public void delete(Long contentId) {
        this.contentMapper.deleteByPrimaryKey(contentId);
    }

    @Override
    public void updateContent(ContentEntity contentEntity) {
        this.contentMapper.updateContent(contentEntity);
    }
}
