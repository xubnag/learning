package com.xubang.mapLearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/9 9:43 PM
 * @Description map初步认识
 */
@SpringBootTest
public class MapAcquaintanceFirst_001 {


    @Test
    public void test001() {
        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("01", "北京烤鸭");
        stringMap.put("", "");
    }

    /**
     * 目的：统计一份列表中，不同对象的出现次数：不同动物的总数
     * 方法一：Map计算
     */
    @Test
    public void test002() {
        List<String> animalList = Arrays.asList("dog", "pig", "dog", "cat", "tiger", "leopard", "leopard");
        HashMap<String, Integer> map = new HashMap<>();
        for (String animal : animalList) {
            Integer animalNum = map.get(animal);
            map.put(animal, animalNum == null ? 1 : ++animalNum);
        }
        System.out.println(map);
    }

    /**
     * 目的：统计一份列表中，不同对象的出现次数：不同动物的总数
     * 方法一：Stream8中 map.compute新方法
     */
    @Test
    public void test003() {
        List<String> animalList = Arrays.asList("dog", "pig", "dog", "cat", "tiger", "leopard", "leopard");
        Map<String, Integer> map = new HashMap<>();
        for (String animal : animalList) {
            map.compute(animal, (k, v) -> v == null ? 1 : ++v);
        }
        System.out.println(map);
    }
}