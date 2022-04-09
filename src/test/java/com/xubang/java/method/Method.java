package com.xubang.java.method;

import java.io.File;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/26 2:59 PM
 * @Description 方法的重载
 */
public class Method {
    public static void main(String[] args) {
        System.out.println(add(10,20,30,40,50));
        
    }

//    public static int add (int a, int b){
//       return a+b;
//    }
//
//    public static int add (int a, int b, int c){
//       return a+b+c;
//    }
//
//    public static int add (int a, int b, int c, int d){
//        return a+b+c+d;
//    }

    public static int add (int a, int... b){
        for (int i : b) {
            a=a+i;
        }
        return a;
    }


}
