package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/27.
 */
@Table(name = "wor_bookhit")
public class BookHitEntity implements Serializable {
    private static final long serialVersionUID = -4727107838312072082L;
    @Column(name = "bookHitId", unique = true, nullable = false)
    private Long bookHitId;
    @Column(name = "bookId", unique = true, nullable = false)
    private Long bookId;
    @Column(name = "userId", unique = true, nullable = false)
    private Long userId;
    @Column(name = "bookHitDate")
    private Date bookHitDate;

    public Long getBookHitId() {
        return bookHitId;
    }

    public void setBookHitId(Long bookHitId) {
        this.bookHitId = bookHitId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBookHitDate() {
        return bookHitDate;
    }

    public void setBookHitDate(Date bookHitDate) {
        this.bookHitDate = bookHitDate;
    }
}
