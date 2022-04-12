package com.xubang.model;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/10 10:36 AM
 * @Description Employee的子类
 */
public class NewEmployee {
    private String name;
    private Long age;

    public NewEmployee() {
    }

    public NewEmployee(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}