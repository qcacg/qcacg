package com.qcacg.mapper;

import com.qcacg.entity.BookEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<BookEntity> {

    public List<BookEntity> findBookByUserId(Long userId);


}