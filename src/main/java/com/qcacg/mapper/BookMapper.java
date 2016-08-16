package com.qcacg.mapper;

import com.qcacg.entity.BookEntity;

public interface BookMapper {
//    int countByExample(BookEntityExample example);
//
//    int deleteByExample(BookEntityExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(BookEntity record);

    int insertSelective(BookEntity record);

//    List<BookEntity> selectByExampleWithBLOBs(BookEntityExample example);
//
//    List<BookEntity> selectByExample(BookEntityExample example);

    BookEntity selectByPrimaryKey(Integer bookId);

//    int updateByExampleSelective(@Param("record") BookEntity record, @Param("example") BookEntityExample example);
//
//    int updateByExampleWithBLOBs(@Param("record") BookEntity record, @Param("example") BookEntityExample example);
//
//    int updateByExample(@Param("record") BookEntity record, @Param("example") BookEntityExample example);

    int updateByPrimaryKeySelective(BookEntity record);

    int updateByPrimaryKeyWithBLOBs(BookEntity record);

    int updateByPrimaryKey(BookEntity record);
}