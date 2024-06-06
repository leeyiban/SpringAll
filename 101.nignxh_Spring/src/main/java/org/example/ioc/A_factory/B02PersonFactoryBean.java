package org.example.ioc.A_factory;

import org.example.ioc.pojo.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author:ningxh
 * @date:2023/5/27 13:37
 * @description: IOC之FactoryBean接口方式创建对象
                 * 步骤如下:
                 * 1 编写一个类去实现工厂接口
                 * 2 实现接口方法
                 * 3 到applicationContext.xml中去配置
 */
public class B02PersonFactoryBean implements FactoryBean<Person> {
    public boolean isSingleton() {
        return true;
    }

    public Person getObject() throws Exception {
        return new Person(100, "工厂实例方法", 110,"15705692656");
    }

    public Class<?> getObjectType() {
        return Person.class;
    }
}
