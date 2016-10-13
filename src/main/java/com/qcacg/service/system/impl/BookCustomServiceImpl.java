package com.qcacg.service.system.impl;

import com.qcacg.entity.book.BookCustom;
import com.qcacg.mapper.BookCustomMapper;
import com.qcacg.service.system.BookCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/10.
 */
@Service
public class BookCustomServiceImpl implements BookCustomService {
    @Autowired
    BookCustomMapper bookCustomMapper;

    @Override
    public BookCustom queryBook(Long bookId) {
        return this.bookCustomMapper.queryBook(bookId);
    }
}
