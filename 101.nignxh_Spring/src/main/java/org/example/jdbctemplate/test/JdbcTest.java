package org.example.jdbctemplate.test;

import org.example.jdbctemplate.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:ningxh
 * @date:2023/5/28 10:05
 * @description: some description
 */
@ContextConfiguration(locations = "classpath:jdbcTemplate/jdbcTemplateApplicationContext.xml].xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTest  {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        System.out.println("jdbcTemplate = " + jdbcTemplate);
    }

    /* 将id=5的记录的salary字段更新为1300.00 */
    @Test
    public void test2() throws Exception {
        // 实验2：将emp_id=5的记录的salary字段更新为1300.00
        String sql = "update employee set salary = ? where id = ?";
        jdbcTemplate.update(sql, 1300, 5);
    }

    /* 批量插入 */
    @Test
    public void test3() throws Exception {
        String sql = "insert into employee(`name`,`salary`) values(?,?)";
        ArrayList<Object[]> params = new ArrayList<>();
        params.add(new Object[]{"aaa", 100});
        params.add(new Object[]{"bbb", 100});
        params.add(new Object[]{"ccc", 100});
        jdbcTemplate.batchUpdate(sql, params);
    }

    /* ：查询id=5的数据库记录，封装为一个Java对象返回 */
    @Test
    public void test4() throws Exception {
        // 实验4：查询id=5的数据库记录，封装为一个Java对象返回
        String sql = "select id ,name ,salary from employee where id = ?";
        BeanPropertyRowMapper<Employee> mapper = new BeanPropertyRowMapper<>(Employee.class);
        /**
         * 在queryRunner中使用的是ResultSetHandler
         * 	在Spring的jdbcTemplate中，使用RowMapper。
         * 		BeanPropertyRowMapper 可以把一个结果集转成一个bean对象
         */
        Employee employee = jdbcTemplate.queryForObject(sql, mapper, 5);
        System.out.println(employee);
    }


    /* 查询salary>4000的数据库记录，封装为List集合返回 */
    @Test
    public void test5() throws Exception {
        // 实验5：查询salary>4000的数据库记录，封装为List集合返回
        String sql = "select id,name,salary from employee where salary > ?";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class), 4000);
        System.out.println(list);
    }

    /* 查询最大salary */
    @Test
    public void test6() throws Exception {
        // 实验6：查询最大salary
        String sql = "select max(salary) from employee";
        BigDecimal salary = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println(salary);
    }


    // 使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void test7() throws Exception {
        // 实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "小明");
        param.put("salary", new BigDecimal(55));
        namedParameterJdbcTemplate.update(sql, param);
    }


    /* 实验8：重复实验7，以SqlParameterSource形式传入参数值 */
    @Test
    public void test8() throws Exception {
        // 实验8：重复实验7，以SqlParameterSource形式传入参数值
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";
        // 通过一个bean对象的属性会自动赋值
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(new Employee(0,
                "小新", new BigDecimal(11111)));
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }
}
