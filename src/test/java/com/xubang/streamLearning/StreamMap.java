package com.xubang.streamLearning;

import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/19 6:00 PM
 * @Description map映射
 */
@SpringBootTest
public class StreamMap {


    /**
     * 映射
     * map:接收一个lambda函数作为参数，该函数将应用到每一个元素上，进而实现：将元素转化为新的形式或者提取信息；
     * flatMap:接收一个函数作为参数，将流中的每一个值都转化为一个流，最终拼接所有的流为一个流。
     */
    @Test
    public void testMap() {
        //map转化每一个元素
        List<String> stringList = Arrays.asList("123", "ass", "123dsr", "哈哈哈");
        stringList.stream()
                .map((str) -> str.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        //map提取元素
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setAge(18 + i).setName("xubang" + i);
            employeeList.add(employee);
        }
        employeeList.stream()
                .map((str) -> str.getName())
                .forEach(System.out::println);
    }

    @Test
    public void testflatMap() {
        List<String> stringList = Arrays.asList("123", "ass", "123dsr", "哈哈哈");

        //使用map:将stringList中每一个str转化为char类型
        Stream<Stream<Character>> streamStream = stringList.stream()
                .map(StreamMap::filterCharacter);  //{{a,a,a},{b,b,b},{c,c,c}}
        //stream流的中间操作不会有任何值出现的
        System.out.println("map方式：" + streamStream);
        //stream流的终止操作才会出现最终的值
        streamStream
                .forEach(x -> x.forEach(System.out::println));

        //使用flatMap
        System.out.println("------flatMap------");
        stringList.stream()
                .flatMap(StreamMap::filterCharacter)
                .forEach(System.out::println);  //{a,a,a,b,b,b,c,c,c}

    }

    //将string转化为stream形式的 character
    private static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        //str转化为字符数组
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * map:flatMap ≈ add:addAll
     */
    @Test
    public void testAdd() {
        List<String> stringList = Arrays.asList("123", "ass", "123dsr", "哈哈哈");
        List stringListN = new ArrayList<>();
        stringListN.add("aaa");
        stringListN.add("bbb");
        stringListN.add(stringList);
        System.out.println("add:"+stringListN);
        stringListN.addAll(stringList);
        System.out.println("addAll:"+stringListN);
    }
}
