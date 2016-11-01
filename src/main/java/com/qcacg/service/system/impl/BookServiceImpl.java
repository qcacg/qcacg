package com.qcacg.service.system.impl;

import com.github.pagehelper.PageInfo;
<<<<<<< HEAD
import com.qcacg.constant.CodeConstant;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
import com.qcacg.entity.BookEntity;
import com.qcacg.entity.VolumeEntity;
import com.qcacg.mapper.BookMapper;
import com.qcacg.service.BaseServiceImpl;
import com.qcacg.service.system.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.List;
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553

/**
 * Created by Administrator on 2016/7/4.
 */
@Service
public class BookServiceImpl extends BaseServiceImpl<BookEntity> implements BookService {


    @Autowired
    private BookMapper bookMapper;
    @Override
    public BookEntity findByBookId(Long bookId) {

        BookEntity entity = new BookEntity();
        entity.setBookId(bookId);
        return this.findByObject(entity);
    }

    @Override
    public PageInfo<BookEntity> queryBookForList(BookEntity bookEntity) {
        return this.queryPageForList(bookEntity);
    }

    @Override
    public void saveOrUpdateBook(BookEntity bookEntity) {

        try
        {
            if (bookEntity.getBookId() == null)
            {
                 this.insertBook(bookEntity);
            } else
            {
                 this.updateBook(bookEntity);
            }
        } catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    @Override
    public List<BookEntity> findBookByUserId(Long userId) {

        return this.bookMapper.findBookByUserId(userId);
    }

    @Override
    public void insertBook(BookEntity bookEntity) {
         this.bookMapper.insertBook(bookEntity);
    }

    @Override
    public void updateBook(BookEntity bookEntity) {
         this.bookMapper.updateBook(bookEntity);
    }

    @Override
    public List<BookEntity> findBookByBookUpDate() {
        return this.bookMapper.findBookByBookUpDate();
    }

    @Override
    public List<BookEntity> WeekBookByBookCopperCoins() {
        return this.bookMapper.WeekBookByBookCopperCoins();
    }

    @Override
    public List<BookEntity> MonthBookByBookCopperCoins() {
        return this.bookMapper.MonthBookByBookCopperCoins();
    }

    @Override
    public List<BookEntity> WeekBookByBookHit() {
        return this.bookMapper.WeekBookByBookHit();
    }

    @Override
    public List<BookEntity> MonthBookByBookHit() {
        return this.bookMapper.MonthBookByBookHit();
    }

    @Override
    public List<BookEntity> WeekBookByBookWordCount() {
        return this.bookMapper.WeekBookByBookWordCount();
    }

    @Override
    public List<BookEntity> MonthBookByBookWordCount() {
        return this.bookMapper.MonthBookByBookWordCount();
    }

    @Override
    public void userUpdateBookStatus(Long bookId) {
        this.bookMapper.userUpdateBookStatus(bookId);
    }

    @Override
    public void adminUpdateBookStatus(Long bookId) {
        this.bookMapper.adminUpdateBookStatus(bookId);
    }

    @Override
    public List<BookEntity> queryBookForCheck() {
        return this.bookMapper.queryBookForCheck();
    }

    @Override
    public List<BookEntity> findBookByBookCopperCoins() {
        return this.bookMapper.findBookByBookCopperCoins();
    }

    @Override
    public List<BookEntity> findBookByBookHit() {
        return this.bookMapper.findBookByBookHit();
    }

    @Override
    public List<BookEntity> findBookByBookWordCount() {
        return this.bookMapper.findBookByBookWordCount();
    }

    @Override
    public boolean findBookByBookName(String bookName, Long bookId) {
        if(bookId == null) {
            if(bookName != null) {
                List<BookEntity> list = this.bookMapper.findBookByBookName(bookName);
                if(list.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD

    @Override
    public Map<String, Object> bookFromSale(List list) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(list.size() == 0) {
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.NULL_SELECT_MSG);
            return map;
        }
        for(int i = 0; i < list.size(); i++) {
            if(!(list.get(i) instanceof Long)) {
                map.put("code", CodeConstant.PARAMETER_CODE);
                map.put("msg", CodeConstant.UNABLE_HANDLE_PARAM);
                return map;
            }
        }
        map.put("msg", "您选择的书籍下架成功");
        return map;
    }

    @Override
    public Map<String, Object> removeBook(List list) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(list.size() == 0) {
            map.put("code", CodeConstant.PARAMETER_CODE);
            map.put("msg", CodeConstant.NULL_SELECT_MSG);
            return map;
        }
        for(int i = 0; i < list.size(); i++) {
            if(!(list.get(i) instanceof Long)) {
                map.put("code", CodeConstant.PARAMETER_CODE);
                map.put("msg", CodeConstant.UNABLE_HANDLE_PARAM);
                return map;
            }
        }
        map.put("msg", "您选择的删除成功");
        return map;
    }
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
}
