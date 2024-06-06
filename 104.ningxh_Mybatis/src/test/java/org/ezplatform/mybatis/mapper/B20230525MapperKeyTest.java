package org.ezplatform.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ezplatform.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

public class B20230525MapperKeyTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void queryUserMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            B20230525MapperKey mapper = sqlSession.getMapper(B20230525MapperKey.class);
            Map<String, User> stringUserMap = mapper.queryUserMap();
            String s = JSON.toJSONString(stringUserMap);
            System.out.println(s);   //{"ningxh":{"id":3,"lastName":"ningxh","sex":1},"zhangsan":{"id":7,"lastName":"zhangsan","sex":1}}


        } finally {
            sqlSession.close();
        }
    }
}