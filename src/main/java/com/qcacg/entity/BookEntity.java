package com.qcacg.entity;

import java.io.Serializable;
import java.util.Date;

public class BookEntity implements Serializable {

    private static final long serialVersionUID = 6038205453038067810L;

    private Long bookId;

    private Long userId;

    private Long partitionId;

    private String bookName;

    private Date bookUpdated;

    private String bookCoverImage;

    private Long bookWordCount;

    private String bookStatus;

    private Long bookHits;

    private Long bookCollections;

    private Long bookCopperCoins;

    private Long bookSilverCoins;

    private String bookIntroduction;



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

    public Long getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Long partitionId) {
        this.partitionId = partitionId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBookUpdated() {
        return bookUpdated;
    }

    public void setBookUpdated(Date bookUpdated) {
        this.bookUpdated = bookUpdated;
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

    public Long getBookHits() {
        return bookHits;
    }

    public void setBookHits(Long bookHits) {
        this.bookHits = bookHits;
    }

    public Long getBookCollections() {
        return bookCollections;
    }

    public void setBookCollections(Long bookCollections) {
        this.bookCollections = bookCollections;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BookEntity other = (BookEntity) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPartitionId() == null ? other.getPartitionId() == null : this.getPartitionId().equals(other.getPartitionId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getBookUpdated() == null ? other.getBookUpdated() == null : this.getBookUpdated().equals(other.getBookUpdated()))
            && (this.getBookCoverImage() == null ? other.getBookCoverImage() == null : this.getBookCoverImage().equals(other.getBookCoverImage()))
            && (this.getBookWordCount() == null ? other.getBookWordCount() == null : this.getBookWordCount().equals(other.getBookWordCount()))
            && (this.getBookStatus() == null ? other.getBookStatus() == null : this.getBookStatus().equals(other.getBookStatus()))
            && (this.getBookHits() == null ? other.getBookHits() == null : this.getBookHits().equals(other.getBookHits()))
            && (this.getBookCollections() == null ? other.getBookCollections() == null : this.getBookCollections().equals(other.getBookCollections()))
            && (this.getBookCopperCoins() == null ? other.getBookCopperCoins() == null : this.getBookCopperCoins().equals(other.getBookCopperCoins()))
            && (this.getBookSilverCoins() == null ? other.getBookSilverCoins() == null : this.getBookSilverCoins().equals(other.getBookSilverCoins()))
            && (this.getBookIntroduction() == null ? other.getBookIntroduction() == null : this.getBookIntroduction().equals(other.getBookIntroduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPartitionId() == null) ? 0 : getPartitionId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getBookUpdated() == null) ? 0 : getBookUpdated().hashCode());
        result = prime * result + ((getBookCoverImage() == null) ? 0 : getBookCoverImage().hashCode());
        result = prime * result + ((getBookWordCount() == null) ? 0 : getBookWordCount().hashCode());
        result = prime * result + ((getBookStatus() == null) ? 0 : getBookStatus().hashCode());
        result = prime * result + ((getBookHits() == null) ? 0 : getBookHits().hashCode());
        result = prime * result + ((getBookCollections() == null) ? 0 : getBookCollections().hashCode());
        result = prime * result + ((getBookCopperCoins() == null) ? 0 : getBookCopperCoins().hashCode());
        result = prime * result + ((getBookSilverCoins() == null) ? 0 : getBookSilverCoins().hashCode());
        result = prime * result + ((getBookIntroduction() == null) ? 0 : getBookIntroduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", userId=").append(userId);
        sb.append(", partitionId=").append(partitionId);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookUpdated=").append(bookUpdated);
        sb.append(", bookCoverImage=").append(bookCoverImage);
        sb.append(", bookWordCount=").append(bookWordCount);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", bookHits=").append(bookHits);
        sb.append(", bookCollections=").append(bookCollections);
        sb.append(", bookCopperCoins=").append(bookCopperCoins);
        sb.append(", bookSilverCoins=").append(bookSilverCoins);
        sb.append(", bookIntroduction=").append(bookIntroduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}