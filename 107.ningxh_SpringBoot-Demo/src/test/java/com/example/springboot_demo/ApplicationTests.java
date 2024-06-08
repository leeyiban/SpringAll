package com.example.springboot_demo;

import org.example.bean.NingxhBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

    @Autowired
    @Qualifier(value = "ningxh")
    private NingxhBean ningxh;
    @Test
    void contextLoads() {
        System.out.println("111" + ningxh.getName());
    }

}
