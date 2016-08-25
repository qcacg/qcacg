package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "wor_content")
public class ContentEntity implements Serializable {
    private static final long serialVersionUID = 1525818970451395420L;
    @Column(name = "contentId", unique = true, nullable = false)
    private Long contentId;
    @Column(name = "chapterId", unique = true, nullable = false)
    private Long chapterId;
    @Column(name = "content")
    private String content;
    @Column(name = "contentWordCount")
    private Long contentWordCount;
    @Column(name = "contentUpdate")
    private String contentUpdate;
    @Column(name = "contentStatus")
    private String contentStatus;
    @Column(name = "contentUrl")
    private String contentUrl;

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(String contentStatus) {
        this.contentStatus = contentStatus;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getContentWordCount() {
        return contentWordCount;
    }

    public void setContentWordCount(Long contentWordCount) {
        this.contentWordCount = contentWordCount;
    }

    public String getContentUpdate() {
        return contentUpdate;
    }

    public void setContentUpdate(String contentUpdate) {
        this.contentUpdate = contentUpdate;
    }
}