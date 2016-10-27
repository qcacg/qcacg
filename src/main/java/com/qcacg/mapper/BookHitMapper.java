package com.qcacg.mapper;

import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookHitEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface BookHitMapper extends Mapper<BookHitEntity> {

    public List<BookEntity> findBookHitByUserId(Long userId);
}
