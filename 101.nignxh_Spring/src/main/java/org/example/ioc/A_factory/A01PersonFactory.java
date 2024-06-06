package org.example.ioc.A_factory;

import org.example.ioc.pojo.Person;

/**
 * @author:ningxh
 * @date:2023/5/27 13:29
 * @description: springIOC javaBeanFactory
 */
public class A01PersonFactory {
    public static Person create(){
        return new Person(100,"工厂静态方法",110,"15705692656");
    }

    public Person create2() {
        return new Person(100, "工厂实例方法", 110,"15705692656");
    }
}
