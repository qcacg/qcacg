package com.qcacg.entity;

import java.io.Serializable;

public class ContentEntity implements Serializable {
    private static final long serialVersionUID = 6687060986873280494L;

    private Integer contentId;

    private Integer chapterId;

    private String content;

    private Integer contentWordCount;

    private String contentPicture;



    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getContentWordCount() {
        return contentWordCount;
    }

    public void setContentWordCount(Integer contentWordCount) {
        this.contentWordCount = contentWordCount;
    }

    public String getContentPicture() {
        return contentPicture;
    }

    public void setContentPicture(String contentPicture) {
        this.contentPicture = contentPicture;
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
        ContentEntity other = (ContentEntity) that;
        return (this.getContentId() == null ? other.getContentId() == null : this.getContentId().equals(other.getContentId()))
            && (this.getChapterId() == null ? other.getChapterId() == null : this.getChapterId().equals(other.getChapterId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getContentWordCount() == null ? other.getContentWordCount() == null : this.getContentWordCount().equals(other.getContentWordCount()))
            && (this.getContentPicture() == null ? other.getContentPicture() == null : this.getContentPicture().equals(other.getContentPicture()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContentId() == null) ? 0 : getContentId().hashCode());
        result = prime * result + ((getChapterId() == null) ? 0 : getChapterId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getContentWordCount() == null) ? 0 : getContentWordCount().hashCode());
        result = prime * result + ((getContentPicture() == null) ? 0 : getContentPicture().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contentId=").append(contentId);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", content=").append(content);
        sb.append(", contentWordCount=").append(contentWordCount);
        sb.append(", contentPicture=").append(contentPicture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}