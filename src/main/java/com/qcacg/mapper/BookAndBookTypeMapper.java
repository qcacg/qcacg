package com.qcacg.mapper;

import com.qcacg.entity.BookAndBookTypeEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface BookAndBookTypeMapper {

    public List<BookAndBookTypeEntity> findBookTypeByBookId(Long bookId);

    public void insertBookAndBookTypeBatch(List<BookAndBookTypeEntity> bookAndBookTypeEntityList);

    public void deleteBookAndBookType(Long bookId);
}
