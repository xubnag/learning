package com.xubang.jucLearning.safety;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/26 11:26 AM
 * @Description 集合类线程安全问题演示
 */
public class ThreadSafety {
    public static void main(String[] args) {

        //并发修改异常展示
//         ArrayList<String> strings = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                //添加
//                strings.add(UUID.randomUUID().toString().substring(0, 8));
//                //查询
//                System.out.println(strings);
//            }, String.valueOf(i)).start();
//        }

//        //并发修改异常-Vector解决方案（古老方法）
//        Vector<String> vector = new Vector<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                //添加
//                vector.add(UUID.randomUUID().toString().substring(0, 8));
//                //查询
//                System.out.println(vector);
//            }, String.valueOf(i)).start();
//        }


//        //并发修改异常-Collections工具类解决方案（古老方法）
//        List<String> strings = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                //添加
//                strings.add(UUID.randomUUID().toString().substring(0, 8));
//                //查询
//                System.out.println(strings);
//            }, String.valueOf(i)).start();
//        }

        //CopyOnWriteArrayList()：写时复制技术（JUC常用方法）
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                //添加
                list.add(UUID.randomUUID().toString().substring(0, 8));
                //查询
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
