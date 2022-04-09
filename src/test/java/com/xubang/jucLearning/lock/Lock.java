package com.xubang.jucLearning.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/23 6:52 AM
 * @Description Lock初步使用
 */
class TicketSale {
    //第一：创建资源类，创建属性和操作方法
    private Integer ticketNumber = 300;

    //ReentrantLock:可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    public void ticketSale() {
        lock.lock();
        //为了避免方法执行异常，导致：锁不能被释放；所以，一般使用try..catch
        try {
            if (ticketNumber > 0) {
                System.out.println(Thread.currentThread().getName() + "：卖出票：" + (ticketNumber--) + ";剩余票" + ticketNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


public class Lock {
    //第二：创建多线程调用资源类的方法
    public static void main(String[] args) {
        /**
         * @FunctionalInterface  函数型注解：标志可以使用lambda表达式哦！
         * public interface Runnable {
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         * public abstract void run ();
         **/
        TicketSale ticketSale = new TicketSale();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticketSale.ticketSale();
            }
        },"aa").start();

         new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticketSale.ticketSale();
            }
        },"bb").start();

          new Thread(()->{
            for (int i = 0; i < 100; i++) {
                ticketSale.ticketSale();
            }
        },"cc").start();
          //start()不一定会马上创建；从源码：private native void start0();中可以看出，start()是否创建，由操作系统决定。
    }
}
