package org.example.aop.B01dynamicproxy.cgllibdynamicproxy.proxy;

import org.example.aop.B01dynamicproxy.cgllibdynamicproxy.log.LogUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author:ningxh
 * @date:2023/5/27 22:31
 * @description: CgLib动态代理
 * cglib会根据给定的目标类，拷贝修改类的字节码对象。从而生成一个代理对象类。再创建出来实例。
 * cglib代理所创建出来的代理对象是目标对象的子类。
 *
 * 优点：在没有接口的情况下，同样可以实现代理的效果。
 * 缺点：同样需要自己编码实现代理全部过程。
 * 但是为了更好的整合Spring框架使用。所以我们需要学习一下Spring 的AOP 功能。也就是学习Spring提供的AOP功能。
 */
public class CgLibProxy {

    public static Object createCglibProxy(Object target){
        // 根据目标对象，产生一个代理对象实例

        // cglib代理技术是通过继承目标对象的字节码对象来产生一个代理对象
        // 代理对象是目标对象的子类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());

        // 设置增强操作
        // MethodInterceptor相当于jdk动态代理的InvocationHandler接口
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * MethodInterceptor#intercept()是每次调用代理方法的时候，就会自动调用的方法（ 代理方法的实现体 ）
             * @param proxy                 代理对象实例
             * @param method                代理对象调用的方法反射对象
             * @param args                  调用方法时传递的参数
             * @param methodProxy           方法反射对象的代理对象实例
             * @return                      返回值也是代理方法的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                try {
                    // 目标方法之前的增强操作，又叫前置通知 | 前置增强
                    LogUtils.logBefore(method.getName(), args);
                    // 执行目标对象
                    Object result = method.invoke(target,args);
                    // 目标方法执行完，用于记录目标方法返回值的增强，又叫返回通知 | 返回增强
                    LogUtils.logAfterReturning(method.getName(),result);

                    return result;
                } catch (Exception e) {
                    // 在异常处实现的增强操作 ， 又叫 异常通知 | 异常增强
                    LogUtils.logAfterThrowing(method.getName(),e);

                    throw new RuntimeException(e);
                }
            }
        });

        // 创建代理对象实例返回
        return enhancer.create();
    }
}
