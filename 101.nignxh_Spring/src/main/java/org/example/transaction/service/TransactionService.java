package org.example.transaction.service;


import org.example.transaction.dao.BookDao;
import org.example.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

/**
 * @author:ningxh
 * @date:2023/5/28 11:41
 * @description: some description
 */
@Service("txtransactionService")
public class TransactionService {
    @Autowired
    @Qualifier("txbookDao")
    BookDao bookDao;

    @Autowired
    @Qualifier("txuerDao")
    UserDao userDao;

    /* Spirng默认事务 在 出现算数异常之后, 第一条执行语句是成功的,第二条没有执行 */
    public void exceptionInSpring() {
        bookDao.updateBook();
        int i = 12 / 0;
        userDao.updateUser();
    }


    /* 配置事务管理器
        步骤:
            1. 配置事务管理器DataSourceTransactionManager到Spring容器中
            2. 配置事务的AOP
            3. 给需要使用事务的方法是添加注解@Transactional
        Spring底层默认是对运行时异常RuntimeException，以及运行时子异常进行回滚事务

            */
    public void multiUpdate() {
        /* Spirng默认事务 在 出现算数异常之后, 第一条执行语句是成功的,第二条没有执行 */
         bookDao.updateBook();
        int i = 12 / 0;
        userDao.updateUser();
    }




    /*
    noRollbackFor和noRollbackForClassName测试不回滚的异常
    Spring底层默认是对运行时异常RuntimeException，以及运行时子异常进行回滚事务
     * @Transactional 注解表示当前方法使用事务 <br/>
     * noRollbackFor 属性指定哪些异常不回滚事务<br/>
     * noRollbackForClassName 属性指定哪些全类名的异常不回滚<br/>
     */
    @Transactional(noRollbackForClassName = "java.lang.ArithmeticException")
    public void ArithmeticDontRollback() {
        /* Spirng默认事务 在 出现算数异常之后, 第一条执行语句是成功的,第二条没有执行 */
        bookDao.updateBook();
        int i = 12 / 0;
        userDao.updateUser();
    }




    /**自定义设置回滚异常  rollbackFor和rollbackForClassName回滚的异常
     * @Transactional 注解表示当前方法使用事务 <br/>
     * rollbackFor 指定哪些异常滚回事务<br/>
     * rollbackForClassName 指定哪些全类名的异常回滚事务 <br/>
     */
    @Transactional(rollbackForClassName = "java.io.FileNotFoundException")
    public void rollbackForException() throws FileNotFoundException {
        bookDao.updateBook();
        int i  = 12 ;
        if (i == 12) {
            throw new FileNotFoundException("我就是找不到，你打我呀");
        }
        userDao.updateUser();
    }



    /** 事务的只读属性
     * 只读，就是只允许执行查询操作，不允许执行写操作（ insert, delete ,update ）.
     * 默认情况下，都是非只读事务
     * 实验4：测试readOnly只读属性
     */
    @Transactional(readOnly = true)
    public void readOnly() throws FileNotFoundException {
        bookDao.updateBook();
        int i  = 12 ;
        if (i == 12) {
            throw new FileNotFoundException("我就是找不到，你打我呀");
        }
        userDao.updateUser();
    }


    /**
     * @Transactional 注解表示当前方法使用事务 <br/>
     *
     * timeout = 3 表示3秒后不允许再执行任何语句，
     */
    @Transactional(timeout = 3)
    public void timeout() {
        bookDao.updateBook();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userDao.updateUser();
    }
}
