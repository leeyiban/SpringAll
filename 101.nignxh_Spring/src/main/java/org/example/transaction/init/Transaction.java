package org.example.transaction.init;

/**
 * @author:ningxh
 * @date:2023/5/28 10:38
 * @description: some description
 */
public class Transaction {

    /*
    * 事务分为声明式和编程式两种:
    声明式事务：声明式事务是指通过注解或xml配置的形式对事务的各种特性进行控制和管理。
    编码式（编程式）事务：指的是通过编码的方式实现事务的声明。
    *  */

    /* 编码方式实现事务  */
   /*  public static void main(String[] args) {
        // Jdbc事务编程
        Connection conn = JdbcUti1s.getConnection();// 获取连接
        try {
            conn.setAutoCommit(false);// 设置手动管理事务
            // 一系列jdbc操作XxService.xxx()方法
            conn.commit();// 提交事务
        } catch (Exception e) {
            conn.rol1back();// 回滚事务
        } finally {
            JdbcUti1s.close(conn);// 关闭连接
        }

    } */


/*
事务的传播特性propagation
    什么是事务的传播行为：
        当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。
            例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。

    事务的传播行为可以由传播属性指定。Spring定义了7种类传播行为。
        传播行为              描述
        REQUIRED            如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，
                            并在自己的事务内运行
        导致:一个事务读到另一个事务的写操作数据，但是这些数据还没提交生效,一旦回滚,先前读取事务就读到脏数据了


        REQUIRED NEW        当前的方法必须启动新事务，并在它自己的事务内运行.如果有事务正在运行，应该将它挂起

        SUPPORTS            如果有事务在运行，当前的方法就在这个事务内运行.否则它可以不运行在事务中.

        NOT SUPPORTE        当前的方法不应该运行在事务中.如果有运行的事务，将它挂起

        MANDATORY           当前的方法必须运行在事务内部，如果没有正在运行的事务，就抛出异常

        NEVER               当前的方法不应该运行在事务中.如果有运行的事务，就抛出异常

        NESTED              如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行.
                            否则，就启动一个新的事务，并在它自己的事务内运行.
 */






    /*
数据库事务隔离级别
        数据库隔离级别是为了解决数据库并发过程中数据的安全问题而存在的四种隔离级别。
    四种事务隔离级别：
        一：读未提交	read uncommitted        该隔离级别的事务可以看到其他事务中未提交的数据。
                                            该隔离级别因为可以读取到其他事务中未提交的数据，
                                            而未提交的数据可能会发生回滚，
                                            因此我们把该级别读取到的数据称之为脏数据，
        二：读已提交	read committed			Oracle默认隔离级别
                                            该隔离级别的事务能读取到已经提交事务的数据，
                                            因此它不会有脏读问题。但由于在事务的执行中可以读取到其他事务提交的结果，
                                            所以在不同时间的相同 SQL 查询中，可能会得到不同的结果，
                                            这种现象叫做不可重复读。

        三：可重复读	repeatable read			MySQL默认隔离级别
                                            它能确保同一事务多次查询的结果一致。但也会有新的问题，比如此级别的事务正在执行时，
                                            另一个事务成功的插入了某条数据，但因为它每次查询的结果都是一样的，
                                            所以会导致查询不到这条数据，自己重复插入时又失败(因为唯一约束的原因)。
                                            明明在事务中查询不到这条信息，但自己就是插入不进去，这就叫幻读

        四：串行事务	serializable            它会强制事务排序，使之不会发生冲突，


    由事务隔离级别产生的几个常见问题：
        读未提交，可导致----->>>> 脏读
        读已提交，可导致----->>>> 不可重复读
        重复读，可导致	----->>>> 幻读
    概念理解:
        脏读:一个事务读到另一个事务的写操作数据，但是这些数据还没提交生效。
        不可重复读:两次以上一模一样的查询得到的结果不一样。
            不可重复读产生的核心问题是，在一个事务第1次读取和第2次读取数据的间隔过程中可以被另外一个事务修改，
            因为在READ_COMMITTED的事务隔离级别下，事务中每次读取数据结束后（事务未结束）就会释放读锁，
            而一旦读锁释放后另外一个事务就可以加写锁，最终导致事务中多次读取该数据的间隙中可以被其它事务修改。
        幻读:在A事务中读取多次相同的一张表的数据，但是B事务在这个过程中做了添加或删除的写操作。
            A事务多次读取的结果并没有得到更新（ 读不到删除和添加 ）。



    一些涉及到的命令
    1.查看当前会话隔离级别
     select @@tx_isolation;

    2.查看系统当前隔离级别
     select @@global.tx_isolation;

    3.设置当前会话隔离级别
     set session transaction isolation level read uncommitted;		读未提交
     set session transaction isolation level read committed;			读已提交
     set session transaction isolation level repeatable read;		可重复读
     set session transaction isolation level serializable;			串行化事务（读写不能并发）

    4.开启事务
        start transaction;

    5.提交事务
     commit;

    6.回滚事务
        rollback;
    *  */












































}
