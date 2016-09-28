package com.qcacg.service.system.impl;

import com.qcacg.entity.BookCollectEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookHitEntity;
import com.qcacg.mapper.BookHitMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service
public class BookHitServiceImpl extends BaseServiceImpl<BookHitEntity> implements BookHitService {

    @Autowired
    BookHitMapper bookHitMapper;

    @Override
    public List<BookEntity> findBookHitByUserId(Long userId) {
        return this.bookHitMapper.findBookHitByUserId(userId);
    }

    public boolean Contain(BookHitEntity bookHitEntity){
        List<BookEntity> bookEntityList = this.bookHitMapper.findBookHitByUserId(bookHitEntity.getUserId());
        List<String> bookIdList = new ArrayList<String>();
        for(BookEntity bookEntity : bookEntityList){
            bookIdList.add(String.valueOf(bookEntity.getBookId()));
        }if(bookIdList.contains(String.valueOf(bookHitEntity.getBookId()))){
            return false;
        }
        return true;
    }
    @Override
    public String saveBookHit(BookHitEntity bookHitEntity) {

        try
        {
            if (this.Contain(bookHitEntity))
            {
                return this.save(bookHitEntity);
            } else
            {
                return null;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
