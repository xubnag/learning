package com.xubang.streamLearning;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/12 12:07 PM
 * @Description Stream简介&基本操作
 */
public class Stream_001 {

    /**
     * Stream流的创建方法
     */
    @Test
    public void test_001() {
        String[] arr = new String[]{"1", "2", "3"};

        List<String> strings = Arrays.asList(arr);
        Stream<String> streamMethod1 = Arrays.stream(arr);
        Stream<String> stringStreamMethod2 = Stream.of("1", "2", "3");
        //method3
        System.out.println(Arrays.stream(arr).collect(Collectors.toSet()));
        System.out.println(streamMethod1.collect(Collectors.toSet()));
        System.out.println(stringStreamMethod2.collect(Collectors.toSet()));
    }


    /**
     * Stream多线程
     * 好问题：https://zhuanlan.zhihu.com/p/356455774
     */
    @Test
    public void test_002() {
        List<String> stringList = Arrays.asList("123", "abc", "efg", "12f");
        try {
            stringList.parallelStream()
                    .forEach(x->x.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stringList);
    }

    /**
     * Stream基本操作
     */
    @Test
    public void test_003(){

    }
}