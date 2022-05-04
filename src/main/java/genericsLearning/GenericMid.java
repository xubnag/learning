package genericsLearning;

import javafx.util.Pair;

import static genericsLearning.GenericBounds.max;


/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/5 5:57 AM
 * @Description 泛型类型参数的限定
 */
public class GenericMid {

    public static void main(String[] args) {
        /**
         * 类型参数的限定：上界为某个具体的类
         */
        GenericBounds<Double, Integer> doubleIntegerGenericBounds = new GenericBounds<>(100.0, 340);
        System.out.println("类限定测试：" + doubleIntegerGenericBounds.sum(0d, 0));

        /**
         * 类型参数的限定：上界为某个接口
         */
        Integer[] arr = {0, 1, 2, 3};

        Integer max = max(arr);
        System.out.println("接口限定测试:"+max);

        /**
         * 类型参数的限定：上界为其他类型参数
         */
//        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
//        integerDynamicArray.add(10);
//        integerDynamicArray.add(100);
//        integerDynamicArray.add(20);
//        new GenericBounds<>()
//        DynamicArray<Number> numberDynamicArray = new DynamicArray<>();
//        numberDynamicArray.addAll()

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
     * U:DynamicArray的类型参数
     */
    public <T extends U> void addAll(DynamicArray<T> c){
        for (int i = 0; i < c.size(); i++) {
            c.add(c.get(i));
        }
    }
}