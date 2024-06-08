package org.example.aop.C01AopLean.impl;

import org.example.aop.C01AopLean.bean.Info;
import org.example.aop.C01AopLean.interfaces.Calculate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:ningxh
 * @date:2023/5/27 22:21
 * @description: some description
 */
@Component
public class Calculator implements Calculate {
    @Override
    public int add(int num1, int num2) {
        System.out.println("方法正式执行");
        return num1 + num2;
    }

    @Override
    public int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    @Override
    public int div(int num1, int num2) {
        return num1 / num2;
    }

    @Override
    public List pushData(String title) {
        ArrayList<Info> list = new ArrayList<Info>();
        list.add(new Info(title, "11111"));
        list.add(new Info(title, "2222"));
        list.add(new Info(title, "3333"));
        System.out.println("方法正在执行");
        return list;
    }


}
