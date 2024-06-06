package org.example.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:ningxh
 * @date:2023/5/28 11:41
 * @description: some description
 */
@Repository("txuerDao")
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int updateUser(){
        return jdbcTemplate.update("update `user` set `username` = ?","用户表被修改");
    }
}
