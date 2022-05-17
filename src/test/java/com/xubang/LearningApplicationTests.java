package com.xubang;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class LearningApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testStringToList() {
        String s = "[1,2,3]";
        String s1 = s.replaceFirst("[", " ");
    }

    @Test
    void testhh() {
        String names = "[1,2,3]";
        List<String> nameList = Stream.of(names.split(",")).collect(Collectors.toList());
        String substring = names.substring(1, names.length() - 1);
        System.out.println(substring);
        List<String> collect = Arrays.stream(substring.split(",")).collect(Collectors.toList());
        List<Integer> codesInteger = collect.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(codesInteger);
    }

    @Test
    void testh2() {
      if(3>2){
          System.out.println("hello");
      }
      if(2>=2){
          System.out.println("2");
      }
    }
}
