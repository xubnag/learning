package com.xubang.jucLearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/13 7:43 AM
 * @Description
 */
public class CustomizationThreadPool {
    /**
     * 公用线程池
     */
    private static ThreadPoolExecutor COMMON_EXECUTOR =
            //IO密集型：线程数 = CPU 核心数 * (1+ IO 耗时/CPU 耗时)
//            new ThreadPoolExecutor(10, 100, 300, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> {
            new ThreadPoolExecutor(10, 10, 30, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> {
                Thread t = new Thread(r, "COMMON_EXECUTOR_THREAD_POOL");
                t.setDaemon(true);
                return t;
            }, (r, executor) -> {
                //调用者执行策略
                callerExecutesThePolicy(r, executor);
//                denyPolicy(r, executor);
            });

    private static ScheduledExecutorService SCHEDULED_EXECUTOR = new ScheduledThreadPoolExecutor(10, r -> {
        Thread t = new Thread(r, "COMMON_EXECUTOR_THREAD_POOL");
        t.setDaemon(true);
        return t;
    }, (r, executor) -> {
        denyPolicy(r, executor);
    });

    public static ThreadPoolExecutor getCommonExecutor() {
        return COMMON_EXECUTOR;
    }

    public static ScheduledExecutorService getScheduledExecutor() {
        return SCHEDULED_EXECUTOR;
    }

    /**
     * 拒绝策略
     *
     * @param r
     * @param executor
     */
    private static void denyPolicy(Runnable r, ThreadPoolExecutor executor) {
        String msg = r.toString() + " rejected from " + executor.toString();
        throw new RejectedExecutionException(msg);
    }

    /**
     * 调用者执行策略
     *
     * @param r
     * @param executor
     */
    private static void callerExecutesThePolicy(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            r.run();
        }
    }
}