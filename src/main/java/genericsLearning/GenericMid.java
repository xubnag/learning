package genericsLearning;

import javafx.util.Pair;

import static genericsLearning.GenericBounds.max;
import static java.lang.Math.E;
import static org.apache.commons.lang3.ArrayUtils.add;


/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/5 5:57 AM
 * @Description 泛型类型参数的限定
 */
public class GenericMid {

    public static void main(String[] args) {
        /**
         * 1.类型参数的限定：上界为某个具体的类
         */
        GenericBounds<Double, Integer> doubleIntegerGenericBounds = new GenericBounds<>(100.0, 340);
        System.out.println("类限定测试：" + doubleIntegerGenericBounds.sum(0d, 0));

        /**
         * 2.类型参数的限定：上界为某个接口
         */
        Integer[] arr = {0, 1, 2, 3};

        Integer max = max(arr);
        System.out.println("接口限定测试:" + max);

        /**
         * 3.类型参数的限定：上界为其他类型参数
         */
        DynamicArray<Number> numbers = new DynamicArray<>();
        DynamicArray<Integer> ints = new DynamicArray<>();
        ints.add(100);
        ints.add(34);
        numbers.addAll(ints);


    }

}

class GenericBounds<U extends Number, V extends Number> extends Pair<U, V> {

    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public GenericBounds(U key, V value) {
        super(key, value);
    }


    /**
     * 类型参数的限定：上界为某个具体的类
     */

    /**
     * 求和方法
     *
     * @param key
     * @param value
     * @return
     */
    public double sum(U key, V value) {
        return getKey().doubleValue() + getValue().doubleValue();
    }


    /**
     * 类型参数的限定：上界为某个接口
     */

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }


    /**
     * 类型参数的限定：上界为其他类型参数
     * T:addAll的类型参数
     * E:DynamicArray的类型参数
     */
    public <T extends E> void addAll(DynamicArray<T> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }

    /**
     * 1）<T extends E>用于定义
     * 类型参数，它声明了一个类型参数T，可放在泛型类定义中类名后面、泛型方法返回值前面。
     * 2）<？extends E>用于实例化
     * 类型参数，它用于实例化泛型变量中的类型参数，只是这个具体类型是未知的，只知道它是E或E的某个子类型。
     */

    /**
     * 类型参数的限定：上界为其他类型参数：更为简单的形式
     *
     * @param c
     */
    public void addAllN(DynamicArray<? extends E> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }

}