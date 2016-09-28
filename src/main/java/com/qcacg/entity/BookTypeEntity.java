package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/21.
 */
@Table(name = "wor_booktype")
public class BookTypeEntity implements Serializable {

    private static final long serialVersionUID = -8679296012618923422L;
    @Column(name = "bookTypeId", unique = true, nullable = false)
    private Long bookTypeId;
    @Column(name = "bookTypeName")
    private String bookTypeName;
    @Column(name = "bookTypeDescription")
    private String bookTypeDescription;


    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getBookTypeDescription() {
        return bookTypeDescription;
    }

    public void setBookTypeDescription(String bookTypeDescription) {
        this.bookTypeDescription = bookTypeDescription;
    }
}
