package com.qcacg.mapper;

import com.qcacg.entity.BookTypeEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public interface BookTypeMapper extends Mapper<BookTypeEntity>{

    public List<BookTypeEntity> queryBookType();
}
