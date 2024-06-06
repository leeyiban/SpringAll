package org.ezplatform.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ezplatform.mybatis.pojo.Clazz;
import org.ezplatform.mybatis.pojo.Key;
import org.ezplatform.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class D20230526ResuleMapTest {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(in);
    }

    /*
            一对一的情况

    * 一般情况下.我们的resultMap并不是应用在简单的JavaBean对象上.
        而是应用在复杂的JavaBean对象上做手动映射会达到很好的效果.
        简单的JavaBean对象就是它的属性都是普通的类型
        复杂的Bean对象,它的属性还有Bean对象类型的情况,或者是集合类型,集合中每个元素又是Bean对象的情况,叫复杂Bean对象.
    *  */
    @Test
    public void queryUsers() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);
            List<User> users = mapper.queryUsers();
            String s = JSON.toJSONString(users);
            System.out.println(s);   //[{"id":1,"lastName":"ningxh","sex":1},{"id":3,"lastName":"ningxh","sex":1},{"id":4,"lastName":"zhangsan","sex":1},{"id":5,"lastName":"zhangsan","sex":1},{"id":6,"lastName":"zhangsan","sex":1},{"id":7,"lastName":"zhangsan","sex":1}]


        } finally {
            sqlSession.close();
        }
    }

    /* 一对一 */
    @Test
    public void queryKeyById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);
            Key key = mapper.queryKeyById(1);
            System.out.println(key);   //[{"id":1,"lastName":"ningxh","sex":1},{"id":3,"lastName":"ningxh","sex":1},{"id":4,"lastName":"zhangsan","sex":1},{"id":5,"lastName":"zhangsan","sex":1},{"id":6,"lastName":"zhangsan","sex":1},{"id":7,"lastName":"zhangsan","sex":1}]
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryKeyById2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);
            Key key = mapper.queryKeyById2(1);
            System.out.println(key);   //[{"id":1,"lastName":"ningxh","sex":1},{"id":3,"lastName":"ningxh","sex":1},{"id":4,"lastName":"zhangsan","sex":1},{"id":5,"lastName":"zhangsan","sex":1},{"id":6,"lastName":"zhangsan","sex":1},{"id":7,"lastName":"zhangsan","sex":1}]
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryClazzById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);
            Clazz clazz = mapper.queryClazzById(1);
            System.out.println(clazz);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void queryStudentsByClazzId() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);

            List<Clazz> clazzes = mapper.queryClazzByIdForTwoStep(1);


            for (Clazz clazz : clazzes) {

                Thread.sleep(6666);

                System.out.println( clazz.getStudentList() );
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryStudentsByClazzId2() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            D20230526ResuleMap mapper = sqlSession.getMapper(D20230526ResuleMap.class);

            Clazz clazz1 = mapper.queryClazzByIdForTwoStep2(1);
                Thread.sleep(6666);
                System.out.println( clazz1.getStudentList() );
        } finally {
            sqlSession.close();
        }
    }
}