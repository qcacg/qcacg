package com.qcacg.service.system.impl;

import com.qcacg.entity.BookCollectEntity;
import com.qcacg.mapper.BookCollectMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
@Service
public class BookCollectServiceImpl extends BaseServiceImpl<BookCollectEntity> implements BookCollectService {

    @Autowired
    BookCollectMapper bookCollectMapper;

    @Override
    public List<BookCollectEntity> findBookCollectByUserId(Long userId) {
        return this.bookCollectMapper.findBookCollectByUserId(userId);
    }

    @Override
    public String saveOrDelete(BookCollectEntity entity) {
        String result = "";
        try
        {
            if (entity.getBookCollectId() == null)
            {
                return this.save(entity);
            } else
            {
                result = this.deleteByPrimaryKey(entity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
