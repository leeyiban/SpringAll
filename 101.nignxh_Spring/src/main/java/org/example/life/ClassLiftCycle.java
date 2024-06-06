package org.example.life;



/*
* Bean的生命周期：
* 十步蒙服本
* 1. 实例化
* 2. 依赖注入
*       3. BeanNameAware  BeanFactoryAware 方法执行啦!
*   4. 初始化前 BeanpostProcessor before方法
*       5. InitialingBean接口的方法执行啦!
* 6. 初始化
*   7. 初始化 Beanpostprotessor after方法
* 8. 使用Bean
* 9. DisposableBean接口的方法执行啦!
* 10. 销霞Bean
* */


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

    public class ClassLiftCycle implements BeanNameAware, InitializingBean, DisposableBean {
    private String name;

    @Override
    public String toString() {
        return "ClassLiftCycle{" +
                "name='" + name + '\'' +
                '}';
    }

    public ClassLiftCycle() {
        System.out.println("1. 无参构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 依赖注入");
        this.name = name;
    }

    private void init() {
        System.out.println("3. 方法初始化");
    }

    private void destory() {
        System.out.println("5. 方法的销毁");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("一. 执行BeanNameAware接口的setBeanName方法 设置Bean的名字");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("三. 执行DisposableBean接口的destroy方法  销毁前的方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("二. 执行InitializingBean接口中的afterPropertiesSet方法");
    }
}
