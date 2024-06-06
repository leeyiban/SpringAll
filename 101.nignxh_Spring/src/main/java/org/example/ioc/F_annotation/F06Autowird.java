package org.example.ioc.F_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author:ningxh
 * @date:2023/5/27 21:32
 * @description: some description
 */
@Service
public class F06Autowird {

    @Qualifier("bookDaoExt")
    @Autowired
    // 如果资源类型的bean不止一个，默认根据@Autowired注解标记的成员变量名作为id查找bean，进行装配
    // 如果根据成员变量名作为id还是找不到bean，可以使用@Qualifier注解明确指定目标bean的id
    BookDao bookDao;


    /**
     * @Autowired 是告诉Spring，自动的从Spring的窗口中查找到需要的Bean对象，自动赋值 <br/>
     * *  1 它会先从Spring容器中按类型找到并注入<br/>
     * *  2 当按类型查找到多个的时候，Spring会继续按变量名做为id继续查找并注入<br/>
     * *  3 我们可以使用注解@Qualifier("bookDaoExt")来指定一个id查找，
     * *  当使用了注解@Qualifier指定id之后。原来的属性名就会忽略。
     *    4 @Autowired(required = false)修改属性required = false允许找不到对象赋值，允许值为null<br/>
     *
     */


    public void soutDao() {
        String name = bookDao.name;
        System.out.println("name = " + name);
    }






    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
