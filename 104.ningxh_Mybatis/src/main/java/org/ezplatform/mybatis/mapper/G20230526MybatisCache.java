package org.ezplatform.mybatis.mapper;

/**
 * @author:ningxh
 * @date:2023/5/26 21:31
 * @description: mybatis缓存
 */
public interface G20230526MybatisCache {
    /* 指的是把经常访问的数据保存到一个高速的缓冲区中.方便后面访问的时候可以快速的获取到这些数据.
        名词,缓存是指被保存在高速缓冲区中的数据,也叫缓存
        缓存只有一个目标,就是为了提高访问速度.

        一级缓存：	同一个SqlSession对象
        二级缓存：	同一个SqlSessionFactory对象.


缓存的使用顺序说明：
        1 当mybatis执行一个查询的时候，会先去二级缓存中查询数据。有就直接返回。
        2 如果二级缓存中没有数据，再到一级缓存中获取，有就直接返回
        3 如果二级，一级都没有要查的数据，则发sql语句到数据库查询
        4 查到结果后会马上放到一级缓存中
        5 当SqlSession关闭的时候，会把一级缓存中的数据同步到二级缓存中
    */



        /* 缓存失效的四种情况：
        *   1.不在同一个SqlSession对象中
        *   2.执行语句的参数不同。缓存中也不存在数据。
        *   3.手动清空缓存数据
        *   4.执行增，删，改，语句，会清空掉缓存
        * */

    /* 1.不在同一个SqlSession对象中 示例:
    public void queryOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
        } finally {
            sqlSession.close();
        }
    }
        @Test
        public void firstCacheFail1() {
            queryOne();
            queryOne();
        }
    * */




    /* 2.执行语句的参数不同。缓存中也不存在数据。 示例:
    * @Test
        public void firstCacheFail2() throws InterruptedException {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            try {
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                System.out.println(mapper.queryUserById(1));
                System.out.println(mapper.queryUserById(2));
            } finally {
                sqlSession.close();
            }

    * */


    /*3.手动清空缓存数据 示例:
  @Test
    public void firstCacheFail3() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            System.out.println(mapper.queryUserById(1));
            sqlSession.clearCache();// 清空缓存
            System.out.println(mapper.queryUserById(1));

        } finally {
            sqlSession.close();
        }
    }
    *  */

    /* 4.执行增，删，改，语句，会清空掉缓存 */




    /* 二级缓存
    * 不同的sqlsession对象公用一个二级缓存
    * 二级缓存的使用：
            1、mybatis二级缓存默认不开启，需要到mybatis-config.xml配置文件中，通过settings配置启动
            2、在Mapper.xml的配置文件中加入 <cache/> 标签表示使用二级缓存。
            3、需要被二级缓存的对象必须要实现java的序列化接口。
       15.2.2、useCache="false"的演示和说明
        在select标签上有一个useCache标签，表示是否使用二级缓存。默认值是true，表示使用。
       15.2.3、flushCache="false"的演示和说明
        在update，delete，insert标签上，都有flushCache属性。表示是否清空缓存。默认是默认是true表示清空缓存。如果是false表示不清空缓存。
    *  */
}
