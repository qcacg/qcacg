package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.BaseService;

/**
 * Created by Administrator on 2016/7/4.
 */
public interface BookService extends BaseService<BookEntity> {

    public BookEntity findByUserId(Long userId);

    public PageInfo<BookEntity> queryBookForList(BookEntity entity);

    public String saveOrUpdate(BookEntity entity,Long txtGroupsSelect[]);
}
