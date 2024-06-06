package org.example.transaction.test;

import org.example.transaction.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

/**
 * @author:ningxh
 * @date:2023/5/28 11:42
 * @description: some description
 */

@ContextConfiguration(locations = "classpath:jdbcTemplate/jdbcTransactionApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionTest {
    @Autowired()
    @Qualifier("txtransactionService")
    TransactionService transactionService;



    /* Spring底层事务管理 AOP代理+切面类DataSourceTransactionManager */
    @Test
    public void test() {
        transactionService.multiUpdate();
    }


    /**
        noRollbackFor和noRollbackForClassName测试不回滚的异常
        Spring底层默认是对运行时异常RuntimeException，以及运行时子异常进行回滚事务
         * @Transactional 注解表示当前方法使用事务 <br/>
         * noRollbackFor 属性指定哪些异常不回滚事务<br/>
         * noRollbackForClassName 属性指定哪些全类名的异常不回滚<br/>
         */
    @Test
    public void ArithmeticDontRollback() {
        transactionService.ArithmeticDontRollback();
    }


    /**自定义设置回滚异常  rollbackFor和rollbackForClassName回滚的异常
     * @Transactional 注解表示当前方法使用事务 <br/>
     * rollbackFor 指定哪些异常滚回事务<br/>
     * rollbackForClassName 指定哪些全类名的异常回滚事务 <br/>
     */
    @Test
    public void rollbackForException() throws FileNotFoundException {
        transactionService.rollbackForException();
    }


    /** 事务的只读属性
     * 只读，就是只允许执行查询操作，不允许执行写操作（ insert, delete ,update ）.
     * 默认情况下，都是非只读事务
     * 实验4：测试readOnly只读属性
     */
    @Test
    public void readOnly() throws FileNotFoundException {
        transactionService.readOnly();
    }



    /** 事务超时属性timeout(秒为单位)
     * * @Transactional 注解表示当前方法使用事务 <br/>
     *  *
     *  * timeout = 3 表示3秒后不允许再执行任何语句，
     */
    @Test
    public void timeout() throws FileNotFoundException {
        transactionService.timeout();
    }



}
