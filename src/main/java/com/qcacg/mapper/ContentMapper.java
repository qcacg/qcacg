package com.qcacg.mapper;

import com.qcacg.entity.ContentEntity;

public interface ContentMapper {
//    int countByExample(ContentEntityExample example);
//
//    int deleteByExample(ContentEntityExample example);

    int deleteByPrimaryKey(Integer contentId);

    int insert(ContentEntity record);

    int insertSelective(ContentEntity record);

//    List<ContentEntity> selectByExample(ContentEntityExample example);

    ContentEntity selectByPrimaryKey(Integer contentId);

//    int updateByExampleSelective(@Param("record") ContentEntity record, @Param("example") ContentEntityExample example);
//
//    int updateByExample(@Param("record") ContentEntity record, @Param("example") ContentEntityExample example);

    int updateByPrimaryKeySelective(ContentEntity record);

    int updateByPrimaryKey(ContentEntity record);
}