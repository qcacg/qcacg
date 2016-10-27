package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/22.
 */
@Table(name = "wor_book_booktype")
public class BookAndBookTypeEntity implements Serializable {

    private static final long serialVersionUID = -692638185629838431L;
    @Column(name = "bookAndBookTypeId", unique = true, nullable = false)
    private Long bookAndBookTypeId;
    @Column(name = "bookId", unique = true, nullable = false)
    private Long bookId;
    @Column(name = "bookTypeId", unique = true, nullable = false)
    private Long bookTypeId;


    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


    public Long getBookAndBookTypeId() {
        return bookAndBookTypeId;
    }

    public void setBookAndBookTypeId(Long bookAndBookTypeId) {
        this.bookAndBookTypeId = bookAndBookTypeId;
    }
}
