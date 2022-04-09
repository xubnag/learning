package com.xubang.streamLearning;

import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/20 9:24 AM
 * @Description stream的查找和匹配
 */
@SpringBootTest
public class StreamFindAndMatch {

    List<Employee> employees = Arrays.asList(
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("aobama", 50, Employee.Status.VOCATION),
            new Employee("mayun", 60, Employee.Status.BUSY),
            new Employee("telangpu", 80, Employee.Status.VOCATION)
    );

    /**
     * allMatch:检查是否匹配所有的元素
     */
    @Test
    public void testAllMatch() {
        boolean result = employees.stream()
                .allMatch(x -> x.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(result);
    }

    /**
     * anyMatch:检查是否至少匹配一个元素
     */
    @Test
    public void testAnyMatch() {
        boolean result = employees.stream()
                .anyMatch(x -> x.getStatus().equals(Employee.Status.FREE));
        System.out.println(result);
    }

    /**
     * noneMatch:检查是否没有匹配所有元素
     */
    @Test
    public void testNoneMatch() {
        boolean result = employees.stream()
                .noneMatch(x -> x.getStatus().equals(Employee.Status.FREE));
        System.out.println(result);
    }


    /**
     * findFirst:返回第一个元素
     */
    @Test
    public void testFindFirst() {
        //将排序后寻找到的first Employee封装到Option容器中，避免（不存在first）空指针异常
        Optional<Employee> first = employees.stream()
                .sorted((x1, x2) -> Double.compare(x1.getAge(), x2.getAge()))
                .findFirst();
        System.out.println(first.get());
    }

    /**
     * 返回当前流中的任意一个元素
     */
    @Test
    public void testFindAny() {
        //将排序后寻找到的first Employee封装到Option容器中，避免（不存在first）空指针异常
        //.stream()：串行执行（永远第一个）
        Optional<Employee> any = employees.stream()
                .filter((s) -> s.getStatus().equals(Employee.Status.VOCATION))
                .findAny();
        System.out.println(any.get());

        //.parallelStream:并行，多个线程一起执行，谁先成功；算谁的（结果就不一定了）
        Optional<Employee> anyParallel = employees.parallelStream()
                .filter((s) -> s.getStatus().equals(Employee.Status.VOCATION))
                .findAny();
        System.out.println(anyParallel.get());
    }

    /**
     * count：返回流中元素的总个数
     */
    @Test
    public void testCount() {
        //将排序后寻找到的first Employee封装到Option容器中，避免（不存在first）空指针异常
        long count = employees.stream()
                .count();
        System.out.println(count);
    }

    /**
     * max:返回流中最大值
     * min:返回流中最小值
     */
    @Test
    public void testMaxANDMin() {

        //max
        //将排序后寻找到的first Employee封装到Option容器中，避免（不存在first）空指针异常
        Comparator<Employee> employeeComparator = (x,s) -> {
            int compare = Double.compare(x.getAge(), s.getAge());
            return compare;
        };
        Optional<Employee> max = employees.stream()
                .max(employeeComparator);
        System.out.println(max);

        //min
        Optional<Employee> min = employees.stream()
                .min((y, z) -> Double.compare(y.getAge(), z.getAge()));
        System.out.println(min);

        Optional<Integer> minN = employees.stream()
                .map(Employee::getAge)
                .min(Double::compare);
        System.out.println(minN.get());
        System.out.println(minN);

    }
}
