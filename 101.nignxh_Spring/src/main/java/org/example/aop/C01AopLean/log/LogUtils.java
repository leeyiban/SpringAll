package org.example.aop.C01AopLean.log;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.aop.C01AopLean.bean.Info;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author:ningxh
 * @date:2023/5/27 22:22
 * @description: some description
 */
@Component
@Aspect
public class LogUtils {
    /*
    * 获取连接点信息
    *JoinPoint 是连接点的信息。
    只需要在通知方法的参数中，加入一个JoinPoint参数。就可以获取到拦截方法的信息。
    注意：是org.aspectj.lang.JoinPoint这个类。
    *  */
    @Before(value = "execution(public int org.example.aop.C01AopLean.impl.Calculator.*(int,int))")
    public static void logBefore(JoinPoint joinPoint) {
        /*  System.out.println(" 当前操作是：" + method + " ， 运算数是： " + Arrays.asList(args)); */


        /*
        * 至于add方法中的切点,为什么能拿到方法名和参数,
        原理应该就是jdk动态代理中invokeHandler接口中的invoke方法中有method 还有args 一样
        所以能够拿到,joinpoint应该只是包装了一下
        *  */

        System.out.println("前置通知 Before()方法名是："
                + joinPoint.getSignature().getName() + ",参数是："
                + Arrays.asList(joinPoint.getArgs()));
        //System.out.println("前置通知");
    }

    @After(value = "execution(public int org.example.aop.C01AopLean.impl.Calculator.*(int,int))")
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("后置通知 Before()方法名是："
                + joinPoint.getSignature().getName() + ",参数是："
                + Arrays.asList(joinPoint.getArgs()));

    }


    @Before(value = "execution(public java.util.List org.example.aop.C01AopLean.impl.Calculator.pushData(String))")
    public static void pushDataBefore(JoinPoint joinPoint) {
       System.out.println("前置通知 @Before");
    }



    /**
     * 模拟万户工作环境,推送统一待办数据
     */
    @After(value = "execution(public java.util.List org.example.aop.C01AopLean.impl.Calculator.pushData(String))")
    public static void pushDataAfter(JoinPoint joinPoint) {
        System.out.println("后置通知 @After");
    }


    /**
     * @AfterReturning 表示返回通知 <br/>
     *  1 在返回通知方法中追加一个参数 -->> Object result 用于接收返回值 <br/>
     *  2 在通知的注解上，使用属性returning = "参数名" 让框架知道哪个参数接收返回值 <br/>
     */
    @AfterReturning(value = "execution(public int org.example.aop.C01AopLean.impl.Calculator.*(int,int))",returning = "result")
    public static void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知 方法名是："
                + joinPoint.getSignature().getName() + " , 返回值是："  + result);
    }


    /**
     * 模拟万户工作环境,推送统一待办数据
     */
    @AfterReturning(value = "execution(public java.util.List org.example.aop.C01AopLean.impl.Calculator.pushData(String))"
            ,returning = "result")
    public static void pushDataAfterReturning(JoinPoint joinPoint, List<Info> result) {
        System.out.println("返回通知 @AfterReturning");
    }



    /**
     * @AfterThrowing 这是异常通知 <br/>
     *  1 在异常通知方法中追加一个参数，用于接收抛出的异常  -->> Exception e <br/>
     *  2 在异常通知上使用属性throwing = "e"指明哪个参数接收抛出的异常 <br/>
     */
    @AfterThrowing(value = "execution(public int org.example.aop.C01AopLean.impl.Calculator.*(int,int))"
            ,throwing = "e")
    public static void logAfterThrowing(JoinPoint joinPoint, Exception e){
        System.out.println("异常通知 方法名是："
                + joinPoint.getSignature().getName() + " , 异常是：" + e);
    }




    /**
     * @Around 表示环绕通知<br/>
     * 1 在环绕通知方法上，使用注解  @Around <br/>
     * 2 环绕通知比普通通知优先执行。 <br/>
     * 3 环绕通知方法一定要把目标方法的返回值返回, 否则普通的返回通知，收不到返回值<br/>
     * 4 环绕通知方法一定要把接收到的异常往外抛，否则普通的异常通知收不到异常<br/>
     */
    /*@Around(value = "execution(public int org.example.aop.C01AopLean.impl.Calculator.*(int,int))")
    public static Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            try {
                System.out.println("环绕前置通知 。。。 ");
                // 执行目标方法
                result = proceedingJoinPoint.proceed();
            } finally {
                System.out.println("环绕后置通知 。。。 ");
            }
            System.out.println("环绕返回通知。。。 ");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕异常通知。。。 ");
            throw throwable;
        }
        return result;

    }*/


    /**
     * 模拟万户工作环境,推送统一待办数据
     */
    @Around(value = "execution(public java.util.List *.pushData(*))")
    public static Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        List proceed = null;
        try {
            System.out.println("包围通知 @Around before");
            proceed = (List) proceedingJoinPoint.proceed();
            System.out.println("包围通知 @Around after");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
        }
        return proceed;
    }
}
