package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ezplatform.mybatis.pojo.Key;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class E20230526KeyMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void queryKeyByIdForSimple() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            E20230526KeyMapper mapper = sqlSession.getMapper(E20230526KeyMapper.class);

            Key key = mapper.queryKeyByIdForSimple(1);

            System.out.println( key );
        } finally {
            sqlSession.close();
        }
    }
}