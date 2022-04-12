package com.xubang.model;

import lombok.Data;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/19 6:07 PM
 * @Description 员工信息
 */
public class Employee {
    private String name;
    private Integer age;
    private Status status;
    private Integer wages;

    public Employee() {
    }

    public Employee(String name, Integer age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Employee(String name, Integer age, Status status, Integer wages) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.wages = wages;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Employee setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Employee setStatus(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    /**
     * 枚举
     */
    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
