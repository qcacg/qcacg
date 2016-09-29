package com.qcacg.mapper;

import com.qcacg.entity.BookEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapper extends Mapper<BookEntity> {

    public List<BookEntity> findBookByUserId(Long userId);

    public void insertBook(BookEntity bookEntity);

    public void updateBook(BookEntity bookEntity);

    public List<BookEntity> findBookByBookUpDate();

    public void userUpdateBookStatus(Long bookId);

    public void adminUpdateBookStatus(Long bookId);

    public List<BookEntity> queryBookForCheck();

}