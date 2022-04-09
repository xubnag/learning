package com.xubang.jucLearning.sync;

import com.xubang.jucLearning.sync.ShareInfo;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/23 8:27 AM
 * @Description 线程间通信
 */
class Share {
    //第一 创建资源类，创建属性和操作方法
    private Integer number = 1;

    //第二 资源类中操作方法：（1）判断（2）执行（3）通知
    public synchronized void increase() throws InterruptedException {
        //（1）判断
        if (number != 0) {
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
        if (number != 1) {
            this.wait();
        }

        //（2）执行
        number--;
        System.out.println("decrease::" + number);

        //（3）通知
        notifyAll();
    }
}

public class SynchronizedInterThreadCommunication {
    //第三 创建多线程调用资源类中的操作方法
    public static void main(String[] args) {
        ShareInfo share = new ShareInfo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "bb").start();
    }
}
