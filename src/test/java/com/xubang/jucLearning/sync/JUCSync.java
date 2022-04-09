package com.xubang.jucLearning.sync;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/21 7:50 AM
 * @Description 多线程的基本实现方式&流程
 */

//第一步：创建资源类，定义资源类的属性和方法
class Ticket {
    //资源类的属性
    private Integer number = 300;

    //资源类的方法
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出：" + (number--) + "剩下：" + number);
        }
    }
}

public class JUCSync {
    //第二步：创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        //创建Ticket对象
        Ticket ticket = new Ticket();

        //创建多线程的方式之一：new Thread(new Runnable(实现类/此处：匿名内部类),"线程名称").start();
        //线程一
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "aa").start();

        //线程二
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "bb").start();

        //线程三
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "cc").start();
    }
}
