package com.xubang.test;

import com.alibaba.schedulerx.common.util.JsonUtil;
import com.alibaba.schedulerx.shade.org.apache.commons.lang.StringUtils;
import com.xubang.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/12 9:58 AM
 * @Description 测试一：测试List<Model>遍历，复制某一属性
 */
@SpringBootTest
public class Test_001 {
    /**
     * 证明：对List<对象>中单个对象进行set赋值，对List<对象>整体，是有作用的
     */
    @Test
    public void test_001() {
        List<Employee> employeeArrayList = Arrays.asList(new Employee("xubang", 18, Employee.Status.VOCATION, 999999),
                new Employee("aobama", 68, Employee.Status.VOCATION, 99999),
                new Employee("liubei", 78, Employee.Status.VOCATION, 99)
        );
        System.out.println(JsonUtil.toJson(employeeArrayList));
        for (Employee employee : employeeArrayList) {
            employee.setAge(10);
        }
        System.out.println(JsonUtil.toJson(employeeArrayList));
    }


    @Test
    public void test_002() {
        String day = "2022-01-12 20:02:33";
        System.out.println(day.substring(0, 10));
    }

    @Test
    public void test_003() {
        String day = "2022-01-12 20:02:33";
        System.out.println(day.substring(0, 10));
    }

    @Test
    public void test_004() {
        String str = "123,23,432,42,25,256,73";
        Long ab = 123L;
        Long cd = 999L;
        if(StringUtils.contains(str,ab.toString())){
            String s = StringUtils.replaceChars(str, ab.toString(), cd.toString());
            System.out.println(s);
        }
        System.out.println(str);
    }



    /**
     * 字符串拼接
     * @param oldUserId
     * @param userIdList
     * @return
     */
    private String contactString(Long oldUserId, List<Long> userIdList) {
        //TODO:封装一个处理方法（全能的，后续自己用）
        String relationUserNew = "";
        for (Long userIdN : userIdList) {
            if (userIdN.equals(oldUserId)) {
                continue;
            }
            relationUserNew +=userIdN.toString()+",";
        }
        if(relationUserNew.length()>0){
            relationUserNew=relationUserNew.substring(0,relationUserNew.length()-1);
        }
        return relationUserNew;
    }

}