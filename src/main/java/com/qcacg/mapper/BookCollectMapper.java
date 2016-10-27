package com.qcacg.mapper;

import com.qcacg.entity.BookCollectEntity;
import com.qcacg.entity.BookEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public interface BookCollectMapper extends Mapper<BookCollectEntity> {

    public List<BookEntity> findBookCollectByUserId(Long userId);


}
