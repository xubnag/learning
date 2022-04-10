/**
 * @author XuBang
 * @version 1.0
 * @date 2022/3/26 2:59 PM
 * @Description 方法的重载
 * Java方法的重载是指一个类中能够定义多个同名方法的现象，在Java当中非常普遍
 * 一个类中的多个方法，具有相同的方法名，但是形参列表不同
 * - 形参列表不同意味着：
 *     - 形参数量不同
 *     - 形参数量相同时，形参的数据类型不同
 *     - 形参数量和数据类型都相同时，形参的数据类型的顺序不同
 */
public class Method_001 {
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
