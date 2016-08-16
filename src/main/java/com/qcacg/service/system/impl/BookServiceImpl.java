package com.qcacg.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcacg.entity.BookEntity;
import com.qcacg.mapper.BookMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
@Service
public class BookServiceImpl extends BaseServiceImpl<BookEntity> implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public BookEntity findByBookId(Long bookId) {

        BookEntity entity = new BookEntity();
        entity.setBookId(bookId);
        return this.findByObject(entity);
    }

    @Override
    public PageInfo<BookEntity> queryBookForList(BookEntity entity) {
        return this.queryPageForList(entity);
    }

    @Override
    public String saveOrUpdate(BookEntity entity) {
        String result = "";
        try
        {
            if (entity.getBookId() == null)
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
    public List<BookEntity> findBookByUserId(Long userId) {

        return this.bookMapper.findBookByUserId(userId);
    }




}
