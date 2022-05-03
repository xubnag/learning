package string;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/28 9:28 PM
 * @Description StringBuilder系统学习
 */
public class StringBuilderLearning {
    public static void main(String[] args) {
        use_001();
    }

    /**
     * StringBuilder的多种构造方法、append()方法、插入、删除、替换、翻转、长度相关方法，后续扩展
     */

    /**
     * 知识点：string字符串拼接，简单情况，直接使用+和+=；
     * 对于复杂情况，尤其是循环的时候，应该直接使用StringBuilder
     */
    private static void user_002() {
        //复杂情况
        String hello = "hello";
        for (int i = 0; i < 3; i++) {
            hello += ",world";
        }

        //编译器处理后，如下：
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder(hello);
            sb.append(",world");
            hello = sb.toString();
        }
    }

    /**
     * 基本使用
     */
    private static void use_001() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append(",world.");
        System.out.println(stringBuilder.toString());
    }
}