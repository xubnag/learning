package com.xubang.jucLearning.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/14 11:07 AM
 * @Description CountDownLatch实战测试
 * CountDownLatch：允许一个线程或者多个线程等待其他完成操作
 * A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
 */
public class CountDownLatchLearning {
    private final static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("1+");
                    c.countDown();
                    System.out.println("2+");
                    c.countDown();
                }
            }).start();
        } catch (Exception e){
            System.out.println(e);
        }

        c.wait();
        System.out.printf("3+");
    }
}