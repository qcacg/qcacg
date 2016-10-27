package com.qcacg.service.system.impl;

import com.qcacg.entity.BookCollectEntity;
import com.qcacg.entity.BookEntity;
import com.qcacg.mapper.BookCollectMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
@Service
public class BookCollectServiceImpl extends BaseServiceImpl<BookCollectEntity> implements BookCollectService {

    @Autowired
    BookCollectMapper bookCollectMapper;

    @Override
    public List<BookEntity> findBookCollectByUserId(Long userId) {
        return this.bookCollectMapper.findBookCollectByUserId(userId);
    }


    public boolean Contain(BookCollectEntity bookCollectEntity){
        List<BookEntity> bookEntityList = this.bookCollectMapper.findBookCollectByUserId(bookCollectEntity.getUserId());
        List<String> bookIdList = new ArrayList<String>();
        for(BookEntity bookEntity : bookEntityList){
            bookIdList.add(String.valueOf(bookEntity.getBookId()));
        }if(bookIdList.contains(String.valueOf(bookCollectEntity.getBookId()))){
            return false;
        }
        return true;
    }
    @Override
    public String saveOrDeleteBookCollect(BookCollectEntity bookCollectEntity) {
        String result = "";
        try
        {
            if (this.Contain(bookCollectEntity))
            {
                result = this.save(bookCollectEntity);
            } else
            {
                result = this.deleteByPrimaryKey(bookCollectEntity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
