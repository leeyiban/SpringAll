package org.example.aop.B01dynamicproxy.jdkdynamicproxy.proxy;

import org.example.aop.B01dynamicproxy.jdkdynamicproxy.log.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:ningxh
 * @date:2023/5/27 22:31
 * @description: 动态代理
 */
public class JdkProxy {


    /*

    优点：这种方式已经解决我们前面所有日记需要的问题。非常的灵活。而且可以方便的在后期进行维护和升级。
    缺点：当然使用jdk动态代理，需要有接口。如果没有接口。就无法使用jdk动态代理。
    *   自己的总结
    *   1.接口A 实现类B  增强方法类C   测试类D  撰写了动态代理的本类E
    *   2.在测试类中 创建B类实例  并将这个实例传递到了本类E中,开始启用jdk动态代理
    *   3. 在本类中  调用了反射包中的Proxy 工具类,开始创建代理对象
    *   4. newProxyInstance 方法需要三个参数
    * `     a. 类加载器
    *       b. 接口的class
    *       c. 实现了InvocationHandler接口的类
    *   5.而我们知道 InvocationHandler.invoke 就是我们送过去的方法,他之后一定会被调用的
    *   6. 在这个方法中就可以 进行代码增强的操作了,下面的这个方法,就相当于执行了实现类B中的方法
    *            result = method.invoke(target, args);
    *   7. 在上面代码innoke方法前后我们可以进行增强操作,调用C中的增强方法了
    *  */

    public static Object getCaculatorPro(Object target) {


        /**
         *  Proxy是反射包中的一个工具类，它的作用就是创建代理<br/>
         *  newProxyInstance()方法用于创建代理实例<br/>
         *     第一个参数是： 目标对象的类加载器 <br/>  指定用哪个类加载器来加载代理对象，在生成的代理类中用于加载代理类的字节码。
         *     第二个参数是： 目标对象实现的所有接口 <br/>    指定代理对象需要实现哪些接口，也就是生成的代理类需要实现哪些接口。
         *     第三个参数是： InvocationHandler 接口的实现类<br/>    指定代理对象的调度方法，即代理对象需要执行的具体操作，通常我们会将封装了目标实例和方法的调用处理类实例作为参数来传递给该方法。
         *     Java动态代理机制会自动根据这三个参数生成相应的代理类和代理对象，
         *
         *      InvocationHandler接口中的代码需要干两件事情<br/>
         *          一:  调用目标对象方法 <br/>
         *          二： 执行增强的代码。<br/>
         */
        return Proxy.newProxyInstance(
                        target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        /**
                         * InvocationHandler#invoke()方法是代理对象每次调用方法时会自动调用。<br/>
                         * @param proxy     表示代理对象本身。
                         * @param method    表示代理对象被调用的方法。
                         * @param args      表示被调用方法的入参。
                         * @return          代理方法的返回值（ 一般是目标方法的返回值 ）
                         * @throws Throwable
                         */
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                Object result = null;
                                try {
                                    // 在目标方法前面的功能，叫前置通知 | 前置增强
                                    LogUtils.logBefore(method.getName(),args);
                                    result = method.invoke(target, args);
                                    // 记录目标方法结果的增强叫返回通知 | 返回增强
                                    LogUtils.logAfterReturning(method.getName(),result);

                                }catch (Exception e) {
                                    // 在目标方法抛出异常后。做的增强操作，叫 异常通知 | 异常增强
                                    LogUtils.logAfterThrowing(method.getName(),e);
                                    throw new RuntimeException(e);
                                }

                                return result;
                            }
        });
    }
}
