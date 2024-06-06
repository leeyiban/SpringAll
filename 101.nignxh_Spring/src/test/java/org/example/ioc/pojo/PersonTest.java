package org.example.ioc.pojo;


import org.example.ioc.F_annotation.F06Autowird;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PersonTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appli = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person personBean = (Person) appli.getBean("personBean");
        System.out.println("personBean = " + personBean);
    }


    /* 根据bean的类型从IOC容器中获取bean的实例 */
    @Test
    public void test() {

        // 在使用Spring的时候,需要先有 Spring容器|Spring IOC容器|IOC容器 对象.
        // 在Spring中有一个接口表示了这个容器对象ApplicationContext
        // ClassPathXmlApplicationContext 表示从类路径下加载xml配置文件创建Spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        // getBean()从容器中获取指定的对象
        /**
         * 1.找到一个就直接返回 <br/>
         * 2.没有找到就报错<br/>
         * 3.找到多个就报错
         */
        // Person person = applicationContext.getBean(Person.class);
        Person person = (Person) applicationContext.getBean("p1");
        System.out.println(person);
    }


    // 通过构造器为bean的属性赋值
    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p3");
        System.out.println(person);
    }


    // index属性指定构造器参数的顺序
    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p4");
        System.out.println(person);
    }


    // 根据构造器参数类型注入选择构造器赋值
    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p5");
        System.out.println(person);
    }

    // IOC之 P名称空间
    @Test
    public void test6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContextByPAndUtil.xml");
        Person person = (Person) applicationContext.getBean("p6");
        System.out.println(person);
    }


    // 根据构造器参数类型注入选择构造器赋值
    @Test
    public void test7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p7");
        System.out.println(person);
    }


    // IOC之子对象的赋值测试
    @Test
    public void test8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p8");
        System.out.println(person);
    }


    // IOC之List属性的赋值
    @Test
    public void test10() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p9");
        System.out.println(person);
    }


    // IOC之Map属性的赋值
    @Test
    public void test11() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p11");
        System.out.println(person);
    }


    // IOC之Properties属性的赋值
    @Test
    public void test12() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p12");
        System.out.println(person);
    }


    // IOC之Properties属性的赋值
    @Test
    public void test13() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContextByPAndUtil.xml");
        Person person = (Person) applicationContext.getBean("p13");
        System.out.println(person);
    }

    // IOC之级联属性赋值
    @Test
    public void test14() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p14");
        System.out.println(person);
    }


    //     IOC之静态工厂方法创建Bean
    @Test
    public void test15() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p15");
        System.out.println(person);
    }


    //     IOC之工厂实例方法创建Bean
    @Test
    public void test16() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p16");
        System.out.println(person);
    }

    // IOC之FactoryBean接口方式创建对象
    /* 步骤如下:
        1 编写一个类去实现工厂接口
        2 实现接口方法
        3 到ioc/applicationContext.xml中去配置 */
    @Test
    public void test17() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p17");
        System.out.println(person);
    }




    /* IOC之继承Bean配置 */
    @Test
    public void test18() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p18");
        System.out.println(person);
    }


    /*
    IOC之Bean配置信息的抽象化
    通过abstract属性创建一个模板bean
    abstract="true" 表示当前的配置信息,只能用于继承,不能实例化
*/
    @Test
    public void test19() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        Person person = (Person) applicationContext.getBean("p19");
        System.out.println(person);
    }


    /*
     IOC之组件创建顺序
        实验20：bean之间的依赖  depends-on 属性
        默认情况下,Spring容器 | Spring IOC容器 | IOC容器 容器中对象创建的顺序是他们在xml中从上到下的配置顺序
        depends-on="b" 如果要创建A,就必须先创建B */
    @Test
    public void test20() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
    }


    @Test
    public void test21() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");

        Person person = (Person) applicationContext.getBean("p21");
        System.out.println(person);


        // 容器关闭
        applicationContext.close();
    }



    @Test
    public void test22() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
        System.out.println(applicationContext.getBean("p22"));

        // 容器关闭
        applicationContext.close();
    }



    @Test
    public void testBeanPostProcessor() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ioc/applicationContext.xml");

        Person person = (Person) applicationContext.getBean("p22");
        System.out.println(person);

        // 容器关闭
        applicationContext.close();
    }


/* 测试 自动注入 */
    @Test
    public void testAutowird() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("ioc/applicationContext.xml");

        F06Autowird person = (F06Autowird) applicationContext.getBean("f06Autowird");
        person.soutDao();

        // 容器关闭
        applicationContext.close();
    }



/* 8、Spring的专有测试
开启步骤:
1. 先导入Spring对junit扩展后的jar包
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-test</artifactId>
                    <version>5.3.9</version> <!-- 替换为你需要的版本号 -->
                    <scope>test</scope>
                </dependency>
2. 配置两个注解
            @ContextConfiguration	配置Spring容器需要的配置文件路径
            @RunWith			配置使用Spring的扩展junit测试


示例:
       @ContextConfiguration(locations = "classpath:applicationContext.xml")
         RunWith 表示使用Spring扩展好的测试类
        @RunWith(SpringJUnit4ClassRunner.class)
*  */







}