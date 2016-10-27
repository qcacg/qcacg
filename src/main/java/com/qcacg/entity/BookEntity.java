package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "wor_book")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -5107757138455912827L;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "sort")
    private String sort;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "bookUpdate")
    private Date bookUpdate;
    @Column(name = "bookCoverImage")
    private String bookCoverImage;
    @Column(name = "bookWordCount")
    private Long bookWordCount;
    @Column(name = "bookStatus")
    private String bookStatus;
    @Column(name = "bookHit")
    private Long bookHit;
    @Column(name = "bookCollect")
    private Long bookCollect;
    @Column(name = "bookCopperCoins")
    private Long bookCopperCoins;
    @Column(name = "bookSilverCoins")
    private Long bookSilverCoins;
    @Column(name = "bookIntroduction")
    private String bookIntroduction;
    @Transient
    private List<Long> bookTypeList;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBookUpdate() {
        return bookUpdate;
    }

    public void setBookUpdate(Date bookUpdate) {
        this.bookUpdate = bookUpdate;
    }

    public String getBookCoverImage() {
        return bookCoverImage;
    }

    public void setBookCoverImage(String bookCoverImage) {
        this.bookCoverImage = bookCoverImage;
    }

    public Long getBookWordCount() {
        return bookWordCount;
    }

    public void setBookWordCount(Long bookWordCount) {
        this.bookWordCount = bookWordCount;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Long getBookHit() {
        return bookHit;
    }

    public void setBookHit(Long bookHit) {
        this.bookHit = bookHit;
    }

    public Long getBookCollect() {
        return bookCollect;
    }

    public void setBookCollect(Long bookCollect) {
        this.bookCollect = bookCollect;
    }

    public Long getBookCopperCoins() {
        return bookCopperCoins;
    }

    public void setBookCopperCoins(Long bookCopperCoins) {
        this.bookCopperCoins = bookCopperCoins;
    }

    public Long getBookSilverCoins() {
        return bookSilverCoins;
    }

    public void setBookSilverCoins(Long bookSilverCoins) {
        this.bookSilverCoins = bookSilverCoins;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }


    public List<Long> getBookTypeList() {
        return bookTypeList;
    }

    public void setBookTypeList(List<Long> bookTypeList) {
        this.bookTypeList = bookTypeList;
    }
}