package com.qcacg.service.system.impl;

import com.qcacg.entity.BookTypeEntity;
import com.qcacg.mapper.BookTypeMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
@Service
public class BookTypeServiceImpl extends BaseServiceImpl<BookTypeEntity> implements BookTypeService{

    @Autowired
    BookTypeMapper bookTypeMapper;
    @Override
    public List<BookTypeEntity> queryBookType() {
        return this.bookTypeMapper.queryBookType();
    }
}
