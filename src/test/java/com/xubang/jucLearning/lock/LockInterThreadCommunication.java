package com.xubang.jucLearning.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/26 9:44 AM
 * @Description Lock 线程间通信
 */

class ShareLock {
    //第一步：创建资源类、资源类内部的属性&执行方法
    private Integer number = 0;

    //可重入锁
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //执行方法
    public void increase() throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                condition.await();
            }
            //执行
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            //通知
            condition.signalAll();
        } finally {
            //防止死锁问题
            lock.unlock();
        }
    }

    //执行方法
    public void decrease() throws InterruptedException {
        lock.lock();
        try {
            //判断  (使用while()防止虚假唤醒问题)
            while (number != 1) {
                condition.await();
            }
            //执行
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            //通知
            condition.signalAll();
        } finally {
            //防止死锁问题
            lock.unlock();
        }
    }
}

public class LockInterThreadCommunication {
    public static void main(String[] args) {
        ShareLock shareLock = new ShareLock();

        new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                try {
                    shareLock.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                try {
                    shareLock.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "bb").start();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    shareLock.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "cc").start();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    shareLock.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "dd").start();
    }
}
