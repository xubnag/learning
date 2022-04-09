package com.xubang.streamLearning;

import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/20 10:26 AM
 * @Description 规约
 */
@SpringBootTest
public class StreamReduce {
    List<Employee> employees = Arrays.asList(
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("aobama", 50, Employee.Status.VOCATION),
            new Employee("mayun", 60, Employee.Status.BUSY),
            new Employee("telangpu", 80, Employee.Status.VOCATION)
    );

    /**
     * reduce:将流中元素反复结合起来，得到一个值
     * identity:初始值
     * <p>
     * Performs a reduction on the elements of this stream, using the provided identity value and an
     * associative accumulation function, and returns the reduced value.
     * <p>
     * T result = identity;
     * for (T element : this stream)
     * result = accumulator.apply(result, element)
     * return result;
     */
    @Test
    public void testReduce() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer result = integers.stream()
                //T reduce(T identity, BinaryOperator<T> accumulator);
                .reduce(0, (x, y) -> x + y);
        System.out.println(result);


        /**
         * map和reduce的连接通常成为：map-reduce模式，因为Google用它进行网络搜索而出名
         */
        //Employee::getAge，可能为空；所以：Optional<T>作为返回值，避免空指针异常
        //Optional:不为空的值，直接使用；若可能为空，则封装到Optional，避免空指针异常
        Optional<Integer> resultN = employees.stream()
                .map(Employee::getAge)
                /**
                 * Adds two integers together as per the + operator.
                 * public static int sum(int a, int b) { return a + b;}
                 */
                .reduce(Integer::sum);
        System.out.println(resultN.get());
    }


}
