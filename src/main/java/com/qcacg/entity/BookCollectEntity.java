package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Table(name = "wor_bookcollect")
public class BookCollectEntity implements Serializable {
    @Column(name = "bookCollectId", unique = true, nullable = false)
    private Long bookCollectId;
    @Column(name = "bookId", unique = true, nullable = false)
    private Long bookId;
    @Column(name = "userId", unique = true, nullable = false)
    private Long userId;
    @Column(name = "bookCollectDate")
    private Date bookCollectDate;

    private static final long serialVersionUID = 2488267222348865907L;

    public Long getBookCollectId() {
        return bookCollectId;
    }

    public void setBookCollectId(Long bookCollectId) {
        this.bookCollectId = bookCollectId;
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

    public Date getBookCollectDate() {
        return bookCollectDate;
    }

    public void setBookCollectDate(Date bookCollectDate) {
        this.bookCollectDate = bookCollectDate;
    }


}