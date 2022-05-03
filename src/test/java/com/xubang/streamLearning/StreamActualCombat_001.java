package com.xubang.streamLearning;

import com.alibaba.schedulerx.common.util.JsonUtil;
import com.xubang.model.Employee;
import com.xubang.model.NewEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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

    /**
     * List<model> 根据某一属性 去重
     */
    @Test
    public void test002() {
        List<Employee> employeeList = employees.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))), ArrayList::new));

        System.out.println("非去重" + JsonUtil.toJson(employees));
        System.out.println("去重：" + JsonUtil.toJson(employeeList));

    }

    /**
     * 对List<model> 中某一属性，进行处理（目前Integer类型可以，String类型不可以）
     */
    @Test
    public void test003() {
        List<Employee> collect = employees.stream().map(e -> e.setAge(e.getAge() + 100))
                .collect(Collectors.toList());
        System.out.println("去重：" + JsonUtil.toJson(collect));
    }




}