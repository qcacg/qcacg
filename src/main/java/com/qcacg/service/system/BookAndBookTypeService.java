package com.qcacg.service.system;

import com.qcacg.entity.BookAndBookTypeEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface BookAndBookTypeService {
    public List<BookAndBookTypeEntity> findBookTypeByBookId(Long bookId);

    public void saveOrUpdateBookType(List<BookAndBookTypeEntity> bookAndBookTypeEntityList, Long bookId);


}
