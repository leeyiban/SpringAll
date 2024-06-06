package org.example.ioc.pojo;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author:ningxh
 * @date:2023/5/27 12:13
 * @description: springIOC javaBean
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private Car car;
    private List<String> list;
    private Map<String,Object> map;
    private Properties props;
    private Car car2;
    private Integer salary;

    public Person(Car car) {
        this.car = car;
    }

    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car, List<String> list) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
        this.list = list;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car, List<String> list, Map<String, Object> map) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
        this.list = list;
        this.map = map;
    }

    public Person(Integer id, List<String> list) {
        this.id = id;
        this.list = list;
    }

    public void init(){
        System.out.println(" 初始化方法 ");
    }

    public void destory(){
        System.out.println(" 销毁方法 ");
    }
}
