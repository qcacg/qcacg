package com.qcacg.service.system;

import com.qcacg.entity.BookCollectEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
public interface BookCollectService extends BaseService<BookCollectEntity> {

    public List<BookCollectEntity> findBookCollectByUserId(Long userId);

    public String saveOrDelete(BookCollectEntity entity);

}
