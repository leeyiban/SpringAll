package org.example.ioc.B_jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author:ningxh
 * @date:2023/5/27 19:34
 * @description: some description
 */
public class D04testDataSource {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ioc/jdbcApplicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
