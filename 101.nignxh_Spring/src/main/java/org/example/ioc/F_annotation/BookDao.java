package org.example.ioc.F_annotation;

import org.springframework.stereotype.Repository;

/**
 * @author:ningxh
 * @date:2023/5/27 21:33
 * @description: 作为spring的bean 被其他类自动注入
 */
@Repository("bookDaoExt")
public class BookDao {
    public String name = "zhangsan";

}
