package org.example.ioc.C_processor;

import org.example.ioc.pojo.Car;
import org.example.ioc.pojo.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author:ningxh
 * @date:2023/5/27 18:48
 * @description: 后置处理器, 可以在对象创建初始化的前后, 对对象做一些扩展, 增强, 等的操作
 *
 *               Bean的后置处理使用步骤:
 *               1 先编写一个类去实现后置处理器接口 BeanPostProcessor
 *               2 实现后置处理器的方法  重写方法
 *               3 去容器中配置后置处理器
 */
public class C03MyBeanPostProcessor  implements BeanPostProcessor {
    /**
     * postProcessBeforeInitialization()在初始化前执行
     * @param bean      正在创建的对象
     * @param beanName  对象的唯一标识
     * @return  正在初始化 ( 创建 ) 的对象
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessBeforeInitialization 初始化之前 id => " + beanName + " , 对象是 => " + bean);

        return bean;
    }




    /**
     * postProcessAfterInitialization() 初始化操作之后执行
     * @param bean      正在(创建|初始化)的对象
     * @param beanName  对象的唯一标识
     * @return  正在初始化 ( 创建 ) 的对象
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" postProcessAfterInitialization 初始化之后 id => " + beanName + " , 对象是 => " + bean);

        if (beanName.equals("p22")) {
            Person person = (Person) bean;
            person.setCar(new Car("马杀拉弟","京C12341",null));
        }

        return bean;
    }
}
