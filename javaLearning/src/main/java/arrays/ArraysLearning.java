package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/28 10:07 PM
 * @Description Arrays类系统学习
 * 核心：toString、排序、查找、以及：复制、比较、批量设置值、计算哈希值
 */
public class ArraysLearning {
    public static void main(String[] args) {
//        arraysToString_001();
        arraysSort_002();
    }

    /**
     * toString方法
     */
    private static void arraysToString_001(){
        //直接输出
        int[] arr = {9,8,3,4};
        System.out.println(arr);
        String[] strArr = {"hello", "world"};
        System.out.println(strArr);

        //toString形式输出
        int[] arrN = {9,8,3,4};
        System.out.println(Arrays.toString(arrN));
        String[] strArrN = {"hello", "world"};
        System.out.println(Arrays.toString(strArrN));
    }

    /**
     * 排序
     */
    private static void arraysSort_002(){
        //正序排序
        String[] arr = {"hello","world", "Break","abc"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //匿名内部类：实现倒序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });
        System.out.println(Arrays.toString(arr));

    }


}