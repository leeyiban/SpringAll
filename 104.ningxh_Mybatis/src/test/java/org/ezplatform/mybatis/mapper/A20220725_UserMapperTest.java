package org.ezplatform.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ezplatform.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class A20220725_UserMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(in);
    }


    @Test
    public void queryUserById() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        A20220725_UserMapper userMapper = sqlSession.getMapper(A20220725_UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User user = userMapper.queryUserById("1");
        System.out.println(user);

        //提交事务
        //sqlSession.commit();
        //	System.out.println("result:" + result);
    }

    @Test
    public void queryUsers() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            List<User> users = mapper.queryUsers();
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void saveUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            User zhangsan = new User(null, "zhangsan", 1);
            int count = mapper.saveUser(zhangsan);
            System.out.println("影响的行数"+count);

            //在xml中添加了配置之后,看看能不能去除保存后的id
            //useGeneratedKeys 表示插入数据后返回主键!
            //keyProperty="id" 是指将返回的主键id,注入到参数的哪个属性中
            Integer id = zhangsan.getId();
            System.out.println("id = " + id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }



    @Test
    public void saveUse2r() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            User zhangsan = new User(null, "zhangsan", 1);
            int count = mapper.saveUse2r(zhangsan);
            System.out.println("影响的行数"+count);

            //在xml中添加了配置之后,看看能不能去除保存后的id
            //useGeneratedKeys 表示插入数据后返回主键!
            //keyProperty="id" 是指将返回的主键id,注入到参数的哪个属性中
            Integer id = zhangsan.getId();
            System.out.println("id = " + id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            int count = mapper.updateUser(new User(1, "ningxh", 1));
            System.out.println("影响的行数"+count);

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserById() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            int i = mapper.deleteUserById(2);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void queryUserByNameAndId() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            List<User> zhangsan = mapper.queryUserByNameAndId("zhangsan", 4);
            String s = JSON.toJSONString(zhangsan);
            System.out.println("s = " + s);
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void queryUserByMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", "zhangsan");
            map.put("id", 4);
            List<User> zhangsan = mapper.queryUserByMap(map);
            String s = JSON.toJSONString(zhangsan);
            System.out.println("s = " + s);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUserLikeName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            List<User> zhangsan = mapper.queryUserLikeName("ning");
            String s = JSON.toJSONString(zhangsan);
            System.out.println("s = " + s);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUserLikeName2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            A20220725_UserMapper mapper = sqlSession.getMapper(A20220725_UserMapper.class);
            List<User> zhangsan = mapper.queryUserLikeName2("ning");
            String s = JSON.toJSONString(zhangsan);
            System.out.println("s = " + s);
        } finally {
            sqlSession.close();
        }
    }
}