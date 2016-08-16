package com.qcacg.mapper;

import com.qcacg.entity.BookCollectEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public interface BookCollectMapper extends Mapper<BookCollectEntity> {

    public List<BookCollectEntity> findBookCollectByUserId(Long userId);


}
