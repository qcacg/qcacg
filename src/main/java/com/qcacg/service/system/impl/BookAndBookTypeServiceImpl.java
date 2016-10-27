package com.qcacg.service.system.impl;

import com.qcacg.entity.BookAndBookTypeEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.mapper.BookAndBookTypeMapper;
import com.qcacg.service.system.BookAndBookTypeService;
import com.qcacg.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
@Service
public class BookAndBookTypeServiceImpl implements BookAndBookTypeService{

    @Autowired
    BookAndBookTypeMapper bookAndBookTypeMapper;


    @Override
    public List<BookAndBookTypeEntity> findBookTypeByBookId(Long bookId) {
        return this.bookAndBookTypeMapper.findBookTypeByBookId(bookId);
    }

    @Override
    public void saveOrUpdateBookType(List<BookAndBookTypeEntity> bookAndBookTypeEntityList, Long bookId) {


        try {
            if (this.bookAndBookTypeMapper.findBookTypeByBookId(bookId).size() == 0) {
                this.bookAndBookTypeMapper.insertBookAndBookTypeBatch(bookAndBookTypeEntityList);
            } else {
                this.bookAndBookTypeMapper.deleteBookAndBookType(bookId);
                this.bookAndBookTypeMapper.insertBookAndBookTypeBatch(bookAndBookTypeEntityList);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
