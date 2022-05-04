package genericsLearning;


import java.util.Arrays;
import java.util.Random;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/5/3 8:39 AM
 * @Description 泛型的基本概念&原理
 */
public class GenericsBasic {
    /**
     * 泛型的基本概念：广泛的类型，类、接口和方法代码可以应用于非常广泛的类型，
     * 代码与它们能够操作的数据类型不再绑定在一起，同一套代码可以用于多种数据类型；
     * 这样，不仅可以复用代码，降低耦合，而且可以提高代码的可读性和安全性。
     *
     * 泛型就是类型参数化，处理的数据类型不是固定的，而是可以作为参数传入。
     */

    /**
     * 泛型擦除：Java有Java编译器和Java虚拟机，编译器将Java源代码转换为.class文件，虚拟机加载并运行.class文件。对于泛型类，Java编译器会将泛型代码转换为普通的非泛型代码。
     *
     * Java泛型是通过擦除实现的，类定义中的类型参数如T会被替换为Object，在程序运行过程中，不知道泛型的实际类型参数
     */

    /**
     * 泛型好处：
     * ·更好的安全性
     * ·更好的可读性
     * 去除烦琐的强制类型转换，再加上明确的类型信息，代码可读性也会更好
     */

    /**
     * 泛型的用途：泛型类最常见的用途是作为容器类。所谓容器类，简单地说，就是容纳并管理多项数据的类
     * 泛型类、泛型方法、泛型接口
     */


    /**
     * 实例
     */
    public static void main(String[] args) {
        /**
         * 泛型类
         */
        DynamicArray<Double> doubleDynamicArray = new DynamicArray<>();
        Random rnd = new Random();
        Integer num = 1 + rnd.nextInt(100);
        for (int i = 0; i < num; i++) {
            doubleDynamicArray.add(Math.random());
        }
        Double d = doubleDynamicArray.get(rnd.nextInt(doubleDynamicArray.size()));
        System.out.println("num=" + num + ",d=" + d);


        /**
         * 泛型方法
         */
        //单个参数
        String[] sArr = {"数学", "数据结构", "计网", "金融", "徐棒", "芯片"};
        int index = indexOf(sArr, "徐棒");
        System.out.println("泛型方法" + index);
        //多个参数


        /**
         * 泛型接口：实现接口时，应该指定具体类型
         */
        GenericsInterface genericsInterface = new GenericsInterface();
        genericsInterface.value=10;
        int i = genericsInterface.compareTo(100);
        System.out.println("泛型接口："+i);
    }

    /**∂
     * 泛型接口
     */
    private static final class GenericsInterface implements Comparable<Integer> {
        private Integer value;

        @Override
        public int compareTo(Integer o) {
            return o.compareTo(this.value);
        }
    }

    /**
     * 泛型方法：单个参数
     *
     * @return
     */
    private static <T> int indexOf(T[] arr, T elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 泛型方法：多个参数
     */
    private static <T, U> XuBang<T, U> makeMoney(T first, U second) {
        XuBang<T, U> xuBang = new XuBang<>(first, second);
        return xuBang;
    }

    private static class XuBang<T, U> {
        public XuBang(T first, U second) {

        }
    }
}

/**
 * 自定义动态数组
 *
 * @param <E>
 */
class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData = new Object[DEFAULT_CAPACITY];

    /**
     * 类似StringBuilder扩容
     *
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }
}

