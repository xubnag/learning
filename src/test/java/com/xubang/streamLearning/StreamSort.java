package com.xubang.streamLearning;

import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/19 7:01 PM
 * @Description stream排序：
 * - 自然排序:Comparable
 * - 定制排序:Comparator
 */
public class StreamSort {

    List<Employee> employees = Arrays.asList(
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("aobama", 50, Employee.Status.VOCATION),
            new Employee("mayun", 60, Employee.Status.BUSY),
            new Employee("telangpu", 80, Employee.Status.VOCATION)
    );

    /**
     * 自然排序  implements Comparable<String>
     */
    @Test
    public void testNaturalOrdering() {
        List<String> stringList = Arrays.asList("bbb", "ass", "aaa", "ccc");
        stringList.stream()
                .sorted()
                .forEach(System.out::println);

    }

    /**
     * 定制排序
     */
    @Test
    public void testCustomSorting() {
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }
}
