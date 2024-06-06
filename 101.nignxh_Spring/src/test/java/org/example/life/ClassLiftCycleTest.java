package org.example.life;

import org.example.ioc.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ClassLiftCycleTest {
    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContextByLifeCycle.xml");
        ClassLiftCycle person = (ClassLiftCycle) applicationContext.getBean("ClassLiftCycle");
        System.out.println("4. " + person);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}