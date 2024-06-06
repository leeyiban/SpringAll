package org.example.ioc.F_annotation;

/**
 * @author:ningxh
 * @date:2023/5/27 21:22
 * @description: 注解
 */
public class F06SpringAnnotation {

    /*
    * Spring配置bean的常用注解有
            @Controller	 				配置web层的组件 Controller控制器             相当于<bean class="com.atguigu.controller.BookController" id="bookController" />
            @Service						配置Service业务层的组件                 @Service("bs") 相当于<bean class="com.atguigu.service.BookService" id="bs" /> <br/>
            @Repository					配置Dao持久层的组件                         相当于<bean class="com.atguigu.dao.BookDao" id="bookDao" />
            @Component					配置Dao层，Web层，Service层之外的对象         相当于<bean class="com.atguigu.pojo.Book" id="book" />
            @Scope						配置Bean对象的作用域，单例，多例。、            @Scope("singleton")//表示单例
    *  */


    /*
    *  包扫描
    实验33：使用context:include-filter指定扫描包时要包含的类
    实验34：使用context:exclude-filter指定扫描包时不包含 的类


         <context:include-filter />	设置包含的内容
        注意：通常需要与use-default-filters属性配合使用才能够达到“仅包含某些组件”这样的效果。即：通过将use-default-filters属性设置为false，

		<context:exclude-filter />	设置排除的内容

*
*
*
*
*
*
类别	示例	说明
annotation	com.atguigu.XxxAnnotation	    过滤所有标注了XxxAnnotation的类。这个规则根据目标组件是否标注了指定类型的注解进行过滤
assignable	com.atguigu.BaseXxx	            过滤所有BaseXxx类的子类。这个规则根据目标组件是否是指定类型的子类的方式进行过滤。
aspectj	    com.atguigu.*Service+	        所有类名是以Service结束的，或这样的类的子类。这个规则根据AspectJ表达式进行过滤。
regex	    com\.atguigu\.anno\.*	        所有com.atguigu.anno包下的类。这个规则根据正则表达式匹配到的类名进行过滤。
custom	    com.atguigu.XxxTypeFilter	    使用XxxTypeFilter类通过编码的方式自定义过滤规则。该类必须实现org.springframework.core.type.filter.TypeFilter接口
//自定义排除
<!--
    context:component-scan 配置包扫描
        base-package="com" 指定要扫描哪个包，以及它的子包都会扫描
-->
<context:component-scan base-package="com">
    <!--
        context:exclude-filter 排除过滤
            type是指定过滤的类型
            expression 过滤的表达式

    <context:exclude-filter type="annotation"
                            expression="org.springframework.stereotype.Repository"/>
    <context:exclude-filter type="assignable"
                            expression="com.atguigu.service.BookService"/>
     -->
</context:component-scan>



自定义包含：
<!--
    context:component-scan 配置包扫描
        base-package="com" 指定要扫描哪个包，以及它的子包都会扫描
        use-default-filters="false"取消默认的扫描规则。@Compoment！@Service！@Controller！@Repository
-->
<context:component-scan base-package="com" use-default-filters="false">
    <context:include-filter type="annotation"
                            expression="org.springframework.stereotype.Repository"/>

    <context:include-filter type="assignable" expression="com.atguigu.service.BookService"/>
</context:component-scan>














     */
}
