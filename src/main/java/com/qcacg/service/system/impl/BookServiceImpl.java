package com.qcacg.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/4.
 */
@Service
public class BookServiceImpl extends BaseServiceImpl<BookEntity> implements BookService {
    @Override
    public BookEntity findByUserId(Long userId) {

        BookEntity entity = new BookEntity();
        entity.setUserId(userId);
        return this.findByObject(entity);
    }

    @Override
    public PageInfo<BookEntity> queryBookForList(BookEntity entity) {
        return null;
    }

    @Override
    public String saveOrUpdate(BookEntity entity, Long[] txtGroupsSelect) {
        return null;
    }
}
