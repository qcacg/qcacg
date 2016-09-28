package com.qcacg.service.system;

import com.qcacg.entity.BookTypeEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public interface BookTypeService  extends BaseService<BookTypeEntity> {
    public List<BookTypeEntity> queryBookType();
}
