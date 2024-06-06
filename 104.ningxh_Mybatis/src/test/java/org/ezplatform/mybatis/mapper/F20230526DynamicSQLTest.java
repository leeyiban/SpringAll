package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ezplatform.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class F20230526DynamicSQLTest {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void queryUsersBySample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            F20230526DynamicSQL mapper = sqlSession.getMapper(F20230526DynamicSQL.class);
            mapper.queryUsersBySample(new User(null, "ningxh", 1)).forEach(System.out::println);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void queryUsersBySampleChoose() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            F20230526DynamicSQL mapper = sqlSession.getMapper(F20230526DynamicSQL.class);
            mapper.queryUsersBySampleChoose(new User(null, null, 1)).forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            F20230526DynamicSQL mapper = session.getMapper(F20230526DynamicSQL.class);

            mapper.updateUser(new User(6, "nignxh", 1));

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void queryUsersByIds() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            F20230526DynamicSQL mapper = session.getMapper(F20230526DynamicSQL.class);
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            ids.add(4);
            ids.add(5);
            mapper.queryUsersByIds(ids).forEach(System.out::println);

        } finally {
            session.close();
        }
    }

    @Test
    public void insertUsers() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            F20230526DynamicSQL mapper = session.getMapper(F20230526DynamicSQL.class);

            List<User> userList = new ArrayList<>();

            userList.add(new User(null, "aaa", 0));
            userList.add(new User(null, "bbb", 1));
            userList.add(new User(null, "ccc", 0));

            mapper.insertUsers(userList);

            session.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            F20230526DynamicSQL mapper = sqlSession.getMapper(F20230526DynamicSQL.class);
            User user1 = mapper.queryUserById("1");
            System.out.println(user1);
        } finally {
            sqlSession.close();
        }
    }
}