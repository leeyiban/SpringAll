package org.example.aop.C01AopLean.impl;

import org.example.aop.C01AopLean.interfaces.Calculate;
import org.springframework.stereotype.Component;

/**
 * @author:ningxh
 * @date:2023/5/27 22:21
 * @description: some description
 */
@Component
public class Calculator implements Calculate {
    @Override
    public int add(int num1, int num2) {
        System.out.println("num1,num2 = " + num1 + "," + num2);
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
}
