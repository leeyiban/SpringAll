package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.ezplatform.mybatis.pojo.Clazz;
import org.ezplatform.mybatis.pojo.Key;
import org.ezplatform.mybatis.pojo.Student;
import org.ezplatform.mybatis.pojo.User;

import java.util.List;

/**
 * @author:ningxh
 * @date:2023/5/26 10:38
 * @description: 查询结果映射
 */
public interface D20230526ResuleMap {

    /* 它可以把查询得到的结果集映射成为需要的数据返回.
        resultMap 可以将查询回来的列和JavaBean中的属性做映射( 建立他们的对应关系 )
        在使用resultMap标签之前,我们都是使用的resultType属性.指定返回值的类型.这个时候Mybatis的底层是做的自动映射.
    */


    /*
             没有Javabean的情况,查询出的结果直接和属性一一对应

     * 一般情况下.我们的resultMap并不是应用在简单的JavaBean对象上.
         而是应用在复杂的JavaBean对象上做手动映射会达到很好的效果.
         简单的JavaBean对象就是它的属性都是普通的类型
         复杂的Bean对象,它的属性还有Bean对象类型的情况,或者是集合类型,集合中每个元素又是Bean对象的情况,叫复杂Bean对象.
     *  */
    public List<User> queryUsers();


    /**
     * 一一对应的情况 Key中含有lock对象的id
     * 根据指定的id值查询出key的信息,以及它对应的Lock锁的信息.
     */
    public Key queryKeyById(Integer id);

    public Key queryKeyById2(Integer id);


    /*  一对多
     一次性,根据id查询出对应班级,以及班级所有学生信息
     <!-- 注意一对一使用的标签是association  一对多标签使用的是:collection  --> */
    public Clazz queryClazzById(Integer id);


    /**
     * 一对多 懒加载
     * 要两步查询班级信息,一次只查班级,一次只查学生<br/>
     */
    public List<Clazz> queryClazzByIdForTwoStep(Integer id);

    /**
     * 根据班级编号查询学生信息
     */
    public List<Student> queryStudentsByClazzId(Integer clazzId);




    /**
     * 一对多 懒加载  第一次查询出来的结果,其中两个参数当做第二次查询的查询条件
     * 要两步查询班级信息,一次只查班级,一次只查学生<br/>
     */
    public Clazz queryClazzByIdForTwoStep2(@Param("id")Integer id);

    /**
     * 根据班级编号查询学生信息
     */
    public List<Student> queryStudentsByClazzId2(@Param("clazzId") Integer clazzId,@Param("stuname")String name);

}
