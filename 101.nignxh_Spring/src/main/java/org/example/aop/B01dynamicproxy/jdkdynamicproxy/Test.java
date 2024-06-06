package org.example.aop.B01dynamicproxy.jdkdynamicproxy;

import org.example.aop.B01dynamicproxy.jdkdynamicproxy.impl.Calculator;
import org.example.aop.B01dynamicproxy.jdkdynamicproxy.interfaces.Calculate;
import org.example.aop.B01dynamicproxy.jdkdynamicproxy.proxy.JdkProxy;

/**
 * @author:ningxh
 * @date:2023/5/27 22:12
 * @description: JDK动态代理测试类
 */
public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JdkProxy objectJdkProxy = new JdkProxy();
        Calculate caculatorPro =(Calculate) objectJdkProxy.getCaculatorPro(calculator);
        int add = caculatorPro.add(1, 2);
        int divresult = caculatorPro.div(1, 1);
        System.out.println("add = " + add);
        System.out.println("divresult = " + divresult);
    }
}
