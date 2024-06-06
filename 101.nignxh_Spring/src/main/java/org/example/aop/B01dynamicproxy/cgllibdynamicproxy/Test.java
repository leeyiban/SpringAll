package org.example.aop.B01dynamicproxy.cgllibdynamicproxy;

import org.example.aop.B01dynamicproxy.cgllibdynamicproxy.impl.Calculator;
import org.example.aop.B01dynamicproxy.cgllibdynamicproxy.proxy.CgLibProxy;

/**
 * @author:ningxh
 * @date:2023/5/27 22:12
 * @description: JDK动态代理测试类
 */
public class Test {
    public static void main(String[] args) {
        CgLibProxy cgLibProxy = new CgLibProxy();
        Calculator calculator = new Calculator();
        // 创建cglib代理对象实例
        Calculator cglibProxy = (Calculator) cgLibProxy.createCglibProxy(calculator);

        int add = cglibProxy.add(100, 100);
        System.out.println(" add 操作，返回值是 => " + add);
    }
}
