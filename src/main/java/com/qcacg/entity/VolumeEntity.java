package com.qcacg.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "wor_volume")
public class VolumeEntity implements Serializable {
    @Column(name = "volumeId", unique = true, nullable = false)
    private Long volumeId;
    @Column(name = "bookId", unique = true, nullable = false)
    private Long bookId;
    @Column(name = "volumeName")
    private String volumeName;

    private static final long serialVersionUID = -4809600648149719389L;

    public Long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Long volumeId) {
        this.volumeId = volumeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }


}