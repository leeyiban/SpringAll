package org.example.aop.C01AopLean;

/**
 * @author:ningxh
 * @date:2023/5/28 0:16
 * @description: some description
 */
public class 切点表达式总结 {
    /*
@PointCut切入点表达式语法格式是：	execution(访问权限 返回值类型 方法全限定名(参数类型列表))
    execution(public int com.atguigu.pojo.Calculator.add(int,int))

    public 			是访问权限
    int 				是返回值类型
    com.atguigu.pojo.Calculator.add 	是方法全限定名
    (int,int) 		参数类型列表

限定符：
    *表示任意的意思：
        1)匹配某全类名下，任意或多个方法。
            execution(public int com.atguigu.pojo.Calculator.*(int,int))
        以上的星表示任意的方法名
        execution(public int com.atguigu.pojo.Calculator.save*(int,int))
        以上的星表示。方法名以save字符串打头，后面任意

        2)在Spring中只有public权限能拦截到，访问权限可以省略（访问权限不能写*）。
        execution(public int com.atguigu.pojo.Calculator.add(int,int))
        public是可以省略的
        execution(int com.atguigu.pojo.Calculator.add(int,int))

        3)匹配任意类型的返回值，可以使用 * 表示
            execution(public * com.atguigu.pojo.Calculator.add(int,int))
        以上的星，表示返回值是任意类型

        4)匹配任意子包。
                    execution(public int com.atguigu.*.Calculator.add(int,int))
        以上的星，表示包名只要是com.atguigu.子包都可以

        5)任意类型参数
        execution(public int com.atguigu.pojo.Calculator.add(int,*))
        表示第二个参数的类型不限制。




    ..：可以匹配多层路径，或任意多个任意类型参数
        1)任意层级的包
                execution(public int com.atguigu..Calculator.add(int,int))
        才上的点点..，表示任意层级的子包


        2)任意个，任意类型的参数
        execution(public int com.atguigu.pojo.Calculator.add(..))
        以上点点，表单任意个，任意类型的参数



    模糊匹配：
        // 表示任意返回值，任意方法全限定符，任意参数
        execution(* *(..))
        // 表示任意返回值，任意包名+任意方法名，任意参数
        execution(* *.*(..))


    精确匹配：
        execution(public int com.atguigu.pojo.Calculator.add(int,int))
        public 是访问权限 必须是public
        int 返回值必须是int
        com.atguigu.pojo.Calculator.add		包名+类名+方法名。必须是add
                (int,int)		两个参数，类型必须都是int



    切入点表达式连接：&& 、||
        // 表示需要同时满足两个表达式
            @Before("execution(public int com.atguigu.aop.Calculator.add(int, int))"
                    + " && "
                    + "execution(public * com.atguigu.aop.Calculator.add(..))")

        // 表示两个条件只需要满足一个，就会被匹配到
            @Before("execution(public int com.atguigu.aop.Calculator.add(int, int))"
                    + " || "
                    + "execution(public * com.atguigu.aop.Calculator.a*(int))")



Spring切面中的代理对象
        在Spring中，可以对有接口的对象和无接口的对象分别进行代理。在使用上有些细微的差别
            1)	如果被代理的对象实现了接口。在获取对象的时候，必须要以接口来接收返回的对象。
                因为有接口的对象返回的代理对象是接口的实现类,而不是接口实现类本身
            2)	如果被代理对象，如果没有实现接口。获取对象的时候使用对象类型本身



SpringAOP的四种通知
    前置通知        @Before(value = "execution(public int com.atguigu.pojo.Calculator.*(int,int))")
    后置通知        @After(value = "execution(public int com.atguigu.pojo.Calculator.*(int,int))")
    返回通知        @AfterReturning(value = "execution(public int com.atguigu.pojo.Calculator.*(int,int))")
    异常通知         @AfterThrowing(value = "execution(public int com.atguigu.pojo.Calculator.*(int,int))")


获取连接点信息
    JoinPoint 是连接点的信息。
    只需要在通知方法的参数中，加入一个JoinPoint参数。就可以获取到拦截方法的信息。
    注意：是org.aspectj.lang.JoinPoint这个类。
    详细示例请参照 org.example.aop.C01AopLean.log.LogUtils 类中的add方法
    至于add方法中的切点,为什么能拿到方法名和参数,
        原理应该就是jdk动态代理中invokeHandler接口中的invoke方法中有method 还有args 一样
        所以能够拿到,joinpoint应该只是包装了一下




关于AOP想execution相关的东西包括前置,后置,异常,环绕通知
都在org.example.aop.C01AopLean.log.LogUtils 这个类里面 要看这个里面的注释



当我们有多个切面，多个通知的时候：
1、切面的执行顺序默认是由切面类的字母先后顺序决定。
在切面类上使用@Order注解决定通知执行的顺序（值越小，越先执行）



AOP的xml方式就不演示了.自己去文档中看
































































































        *  */
    }
