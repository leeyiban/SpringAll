package org.ezplatform.mybatis.nixianggongcheng.mapper;

import org.apache.ibatis.annotations.Param;
import org.ezplatform.mybatis.nixianggongcheng.pojo.Book;
import org.ezplatform.mybatis.nixianggongcheng.pojo.BookExample;

import java.util.List;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}