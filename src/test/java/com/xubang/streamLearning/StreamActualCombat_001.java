package com.xubang.streamLearning;

import com.alibaba.schedulerx.common.util.JsonUtil;
import com.xubang.model.Employee;
import com.xubang.model.NewEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/10 10:30 AM
 * @Description Stream流实战应用
 */
@SpringBootTest
public class StreamActualCombat_001 {

    List<Employee> employees = Arrays.asList(
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("xubang", 18, Employee.Status.VOCATION),
            new Employee("aobama", 50, Employee.Status.VOCATION),
            new Employee("mayun", 60, Employee.Status.BUSY),
            new Employee("telangpu", 80, Employee.Status.VOCATION)
    );

    /**
     * 实战一：将一个List<model对象>中部分元素，提取出来封装到一个新的List<model>中
     */
    @Test
    public void test001() {
        //流处理
        List<NewEmployee> collect = employees.stream()
                .map(result -> new NewEmployee(result.getName(), result.getAge().longValue()))
                .collect(Collectors.toList());
        System.out.println("***********" + collect);
        System.out.println("***********" + JsonUtil.toJson(collect));

        //普通方法
        List<NewEmployee> newEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            NewEmployee newEmployee = new NewEmployee();
            newEmployee.setName(employee.getName());
            newEmployee.setAge(employee.getAge().longValue());
            newEmployees.add(newEmployee);
        }
        System.out.println("-----------" + newEmployees);
        System.out.println("-----------" + JsonUtil.toJson(newEmployees));
    }
}