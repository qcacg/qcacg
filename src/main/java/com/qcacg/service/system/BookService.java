package com.qcacg.service.system;

import com.github.pagehelper.PageInfo;
import com.qcacg.entity.BookEntity;
import com.qcacg.service.BaseService;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553

/**
 * Created by Administrator on 2016/7/4.
 */
public interface BookService extends BaseService<BookEntity> {

    public BookEntity findByBookId(Long bookId);

    public PageInfo<BookEntity> queryBookForList(BookEntity bookEntity);

    public void saveOrUpdateBook(BookEntity bookEntity);

    public List<BookEntity> findBookByUserId(Long userId);

    public void insertBook(BookEntity bookEntity);

    public void updateBook(BookEntity bookEntity);

    public void userUpdateBookStatus(Long bookId);

    public void adminUpdateBookStatus(Long bookId);

    public List<BookEntity> queryBookForCheck();

    public List<BookEntity> findBookByBookCopperCoins();

    public List<BookEntity> findBookByBookHit();

    public List<BookEntity> findBookByBookWordCount();

    public List<BookEntity> findBookByBookUpDate();

    public List<BookEntity> WeekBookByBookCopperCoins();

    public List<BookEntity> MonthBookByBookCopperCoins();

    public List<BookEntity> WeekBookByBookHit();

    public List<BookEntity> MonthBookByBookHit();

    public List<BookEntity> WeekBookByBookWordCount();

    public List<BookEntity> MonthBookByBookWordCount();

    public boolean findBookByBookName(String bookName, Long bookId);
<<<<<<< HEAD

    //将小说下架
    public Map<String, Object> bookFromSale(List list);
    //删除小说
    public Map<String, Object> removeBook(List list);
=======
>>>>>>> 0aa25e77c367abfa3e9bf53151a7fad4b044f553
}
