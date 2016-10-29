package com.qcacg.entity.book;

import com.qcacg.entity.BookEntity;
import com.qcacg.entity.BookTypeEntity;
import com.qcacg.entity.UserEntity;
import com.qcacg.entity.volume.VolumeCustom;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Administrator on 2016/10/10.
 */
public class BookCustom extends BookEntity {

    //使用@Transient注解可以忽略字段,添加该注解的字段不会作为表字段使用.
    @Transient
    private List<VolumeCustom> volumeCustomList;
    @Transient
    private List<BookTypeEntity> bookTypeEntityList;
    @Transient
    private UserEntity userEntity;

    public List<VolumeCustom> getVolumeCustomList() {
        return volumeCustomList;
    }

    public void setVolumeCustomList(List<VolumeCustom> volumeCustomList) {
        this.volumeCustomList = volumeCustomList;
    }

    public List<BookTypeEntity> getBookTypeEntityList() {
        return bookTypeEntityList;
    }

    public void setBookTypeEntityList(List<BookTypeEntity> bookTypeEntityList) {
        this.bookTypeEntityList = bookTypeEntityList;
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
