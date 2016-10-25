package com.qcacg.mapper;

import com.qcacg.entity.BookEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<BookEntity> {

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

    public List<BookEntity> SearchBookByKeyWord(String KeyWord);
}