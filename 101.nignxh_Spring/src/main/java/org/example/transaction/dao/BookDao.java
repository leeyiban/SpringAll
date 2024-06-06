
package org.example.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:ningxh
 * @date:2023/5/28 11:41
 * @description: some description
 */
@Repository("txbookDao")
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public int updateBook(){
        return jdbcTemplate.update("update `book` set `name` = ?","图书表被修改了");
    }
}
