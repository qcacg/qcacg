package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "wor_chapter")
public class ChapterEntity implements Serializable {

    @Column(name = "chapterId", unique = true, nullable = false)
    private Long chapterId;
    @Column(name = "volumeId", unique = true, nullable = false)
    private Long volumeId;
    @Column(name = "chapterName")
    private String chapterName;

    private static final long serialVersionUID = -6756726469420729946L;

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Long volumeId) {
        this.volumeId = volumeId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }


}