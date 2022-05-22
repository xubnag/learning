package com.xubang.jucLearning.threadPool;

import com.xubang.jucLearning.CustomizationThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/18 3:35 PM
 * @Description 线程池测试
 */
public class ThreadPoolTest_002 {
    public static void main(String[] args) {
        ThreadPoolExecutor commonExecutor = CustomizationThreadPool.getCommonExecutor();
        for (int i = 0; i < 500; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {

                        if(Thread.currentThread().getName().equals("main")){
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        }else{
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(10000);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            commonExecutor.execute(runnable);
        }
    }
}