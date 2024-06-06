package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.ezplatform.mybatis.pojo.User;

import java.util.List;

/**
 * @author:ningxh
 * @date:2023/5/26 19:14
 * @description: 动态sql语句
 */
public interface F20230526DynamicSQL {
    /**
     * 查询跟user的lastName有关的用户,或跟user性别相同的用户<br/>
     *  拿 user 的lastName属性做模糊查询,做user的sex查询用户
     */
    public List<User> queryUsersBySample(User user);



    /**
     *  如果lastName值有效,则只用lastName模糊查询 <br>
     *  如果lastName值无效,而sex值有效,则只使用sex查询 <br/>
     *  如果都无效,则可以使用自定义查询条件
     */
    public List<User> queryUsersBySampleChoose(User user);





    /**
     * 更新
     * set语句可以删除set关键字 条件前后的 逗号
     */
    public int updateUser(User user);


    /**
     * foreach语句可以做遍历.经常用于以下两种情况的sql语句生成
     * select * from 表名 where id in( xx ,xx ,xx );
     * @param ids
     * @return
     */
    public List<User> queryUsersByIds(@Param("T123") List<Integer> ids );




    //    insert into 表名(列名,列名) values(值1,值2),(值1,值2),(值1,值2)
    public int insertUsers(List<User> users);



    //sql片段
    // 是指将多个sql语句中公共部分的内容进行抽取.然后在每个sql语句是进行引入( 包含 ). 这样的好处,就是可以统一维护一分
    public User queryUserById( String param);
}
