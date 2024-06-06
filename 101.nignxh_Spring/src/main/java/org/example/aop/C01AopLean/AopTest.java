package org.example.aop.C01AopLean;

import org.example.aop.C01AopLean.interfaces.Calculate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author:ningxh
 * @date:2023/5/27 22:12
 * @description: JDK动态代理测试类
 */

/**
 * locations是位置，表示Spring容器配置文件的路径<br/>
 */
@ContextConfiguration(locations = "classpath:aop/AopApplicationContext.xml")
/**
 * 表示使用Spring扩展的junit测试运行器
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Autowired
    Calculate calculator ;

    @Test
    public void test1() {
        calculator.add(100, 100);
    }
}
