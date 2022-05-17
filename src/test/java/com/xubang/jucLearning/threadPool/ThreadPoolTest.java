package com.xubang.jucLearning.threadPool;

import java.util.concurrent.*;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/18 7:31 AM
 * @Description  https://blog.csdn.net/zk86547462/article/details/111375441
 */
public class ThreadPoolTest {
    /**
     * 1)、继承Thread
     * Thread01 thread = new Thread01();
     * thread.start(); // 启动线程
     * <p>
     * 2)、实现Runnable接口
     * Thread02 runable01 = new Thread02()
     * new Thread(runable01).start();
     * <p>
     * 3)、实现Callable接口+FutureTask(可以拿到返回结果，可以处理异常）
     * FutureTask<Integer> FutureTask = new FutureTask<>(new Thread03());
     * new Thread(futureTask).start();
     * // 阻塞等待整个线程执行完成，获取返回结果
     * Integer integer = futureTask.get();
     * <p>
     * 4)、线程池[ExecutorService]
     * 给线程池直接提交任务。
     * service.execute(new Thread01());
     * 创建：
     * ①、Excutors
     * ②、new ThreadPoolExecutor
     * <p>
     * Future:可以获取到异步结果
     * 方式1和方式2：主进程无法获取线程的运算结果。不适合我们当前的场景。
     * 方式3：主进程可以获取线程的运算结果，但是不利于控制服务器中的线程资源。
     * 方式4：通过如下两种方式初始化线程池：
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main...start...");
        //我们在以后的代码中，三种启动线程的方式都不用，统一使用线程池启动
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FutureTask<Integer> futureTask = new FutureTask<>(new Thred03());
        executorService.execute(futureTask);
        // 阻塞等待整个线程执行完成，获取返回结果
        Integer integer = futureTask.get();
        System.out.println(integer);
        System.out.println("main...end...");
    }

    public static class Thread01 extends Thread {

        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());

            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }

    public static class Thred02 implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程：" + Thread.currentThread().getId());

            int i = 10 / 2;
            System.out.println("运行结果：" + i);
        }
    }

    public static class Thred03 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程：" + Thread.currentThread().getId());

            int i = 10 / 2;
            System.out.println("运行结果：" + i);
            return i;
        }
    }
}