package com.xubang.jucLearning.sync;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/25 8:25 AM
 * @Description 线程间通信-虚假唤醒问题
 */

class ShareInfo {
    //第一 创建资源类，创建属性和操作方法
    private Integer number = 1;

    //第二 资源类中操作方法：（1）判断（2）执行（3）通知
    public synchronized void increase() throws InterruptedException {
        //（1）判断
        while (number != 0) {
            this.wait();
        }

        //（2）执行
        number++;
        System.out.println("increase::" + number);

        //（3）通知
        notifyAll();
    }

    //第二 资源类中操作方法：（1）判断（2）执行（3）通知
    public synchronized void decrease() throws InterruptedException {
        //（1）判断
        while (number != 1) {
            //this.wait()的特性：在哪里睡，就在哪里醒    搭配if(){...}会造成虚假唤醒问题   ——————>   解决方式：搭配while(){...}解决虚假唤醒问题
            //此处的虚假唤醒问题指的是：多个线程  wait()：睡着之后，再次被唤醒；短路了if(){...}判断；使用while(){...}，则不会短路
            this.wait();
        }

        //（2）执行
        number--;
        System.out.println("decrease::" + number);

        //（3）通知
        notifyAll();
    }
}

public class FalseWakeupInterThreadCommunication {
    //第三 创建多线程调用资源类中的操作方法
    public static void main(String[] args) {
        ShareInfo share = new ShareInfo();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "bb").start();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "cc").start();

        new Thread(() -> {
            for (int i = 0; i < 3000; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "dd").start();
    }
}
