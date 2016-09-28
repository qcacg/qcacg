package com.qcacg.service.system;

import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookHitEntity;
import com.qcacg.service.BaseService;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface BookHitService extends BaseService<BookHitEntity> {
    public List<BookEntity> findBookHitByUserId(Long userId);

    public String saveBookHit(BookHitEntity bookHitEntity);
}
