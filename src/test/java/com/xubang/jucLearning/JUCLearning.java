package com.xubang.jucLearning;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/20 5:21 PM
 * @Description JUC初识
 */
public class JUCLearning {
    //线程的状态
//    Thread.State;
//    Object

    public static void main(String[] args) {
//        thread();
        daemon();
    }

    private static void thread() {
        Thread aa = new Thread(() -> {
            //Thread.currentThread().isDaemon():当前线程是否是守护线程
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");

        aa.start();

        //主线程
        System.out.println(Thread.currentThread().getName()+"：over");
    }

    private static void daemon(){
        Thread aa = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"::"+Thread.currentThread().isDaemon());
            while (true){

            }
        },"aa");

        //将线程aa设置为守护线程
        aa.setDaemon(true);
        aa.start();

        System.out.println(Thread.currentThread().getName()+":over");
    }

}
