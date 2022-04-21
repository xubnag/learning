package com.xubang.streamLearning;

import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/20 10:46 AM
 * @Description collect:将流转化为其他形式；接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
 */
@SpringBootTest
public class StreamCollect {

    List<Employee> employees = Arrays.asList(
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("aobama", 50, Employee.Status.VOCATION),
            new Employee("mayun", 60, Employee.Status.BUSY),
            new Employee("telangpu", 80, Employee.Status.VOCATION)
    );

    /**
     * collect
     * Collector接口方法的实现，决定了如何对流执行收集操作（如：收集到List,Set,Map）;但是，Collectors实用类提供了很多静态方法，
     * 可以很方便地创建常见的收集器实例。
     */
    /**
     * 将集合中某一元素，单独提取，进行封装
     */
    @Test
    public void testCollect() {
        System.out.println("------收集到：set中------");
        List<String> collect = employees.stream()
                //提取指定元素
                .map(Employee::getName)
                //添加到指定的List中
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //Collectors：收集器；对Collector的具体实现
        System.out.println("------收集到：set中（去重功效）------");
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("------收集到特殊数据结构：HashSet中------");
        //将提取的系列元素封装到特殊的数据结构中
        HashSet<String> stringHashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        stringHashSet.forEach(System.out::println);

    }

    /**
     * 统计List<model对象>中元素总数、单一元素的平均值、元素某一属性最大值/最小值（获取对象   /   该对象的最大值或者最小值）
     */
    @Test
    public void testOthers() {
        System.out.println("-----个数总数-----");
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("-----年龄平均值-----");
        Double ageAverage = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getAge));
        System.out.println(ageAverage);

        System.out.println("-----年龄总和-----");
        DoubleSummaryStatistics ageSum = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getAge));
        System.out.println(ageSum.getSum());

        System.out.println("-----最大值：maxBy-----");
        Optional<Employee> maxBy = employees.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getAge(), y.getAge())));
        System.out.println(maxBy.get());
        Optional<Integer> collect = employees.stream()
                .map(Employee::getAge)
                .collect(Collectors.maxBy(Integer::compare));
        System.out.println(collect.get());

        System.out.println("-----最小值：minBy-----");
        Optional<Employee> minBy = employees.stream()
                .collect(Collectors.minBy((x, y) -> Double.compare(x.getAge(), y.getAge())));
        System.out.println(minBy.get());

        Optional<Integer> minCollect = employees.stream()
                .map(Employee::getAge)
                .collect(Collectors.minBy(Integer::compare));
        System.out.println(minCollect.get());
    }

    /**
     * List<model对象>根据某一属性进行分组/多级分组
     */
    @Test
    public void testGroup(){
         /**
         * 分组
         */
        System.out.println("-----按照Map分组-----");
        //按照status分组
        Map<Employee.Status, List<Employee>> mapCollect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(mapCollect);

        System.out.println("-----多级分组-----");

        Map<Employee.Status, Map<Object, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) ->
                {
                    //注意：此处一定要带上（Employee）
                    if(((Employee) e).getAge()<=18){
                        return "青少年";
                    }else if(((Employee) e).getAge()>18 && ((Employee) e).getAge()<=30){
                        return "青年";
                    }else {
                        return "中年";
                    }
                })));
        System.out.println(collect);

    }

    /**
     * 分片处理&字符串连接&统计
     */
    @Test
    public void testPartition(){
        //分片处理：根据某一元素，对model对象进行分组
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 20));
        System.out.println(collect);
        System.out.println("----"+collect.get(true));

        //字符串连接：提取某一元素，进行字符串拼接
        String connectionCollect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(connectionCollect);

        //统计某一元素的：平均值、总值、最小值、最大值、总数
        DoubleSummaryStatistics doubleSummaryStatistics = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getAge));
        System.out.println(doubleSummaryStatistics);
    }
}
