/**
 * 利用接口做参数，写个计算器，能完成加减乘除运算
 * (1)定义一个接▣Computable含有一个方法int computer(int n,int m)
 * (2)设计四个类分别实现此接口，完成加减乘除运算。
 * (3)设计一个类UseCompute,类中含有方法：public int useCom(Computable com,int one,int two),此方法能够用传递过来的对象
 * 调用computer方法完成运算，并输出运算的结果。
 * (4)设计一个主类Test,调用UseCompute中的方法useCom来完成加减乘除运算，
 * <p>
 * 1,设计函数式接口，其中有一个唯一的抽象方法，带有两个整型参数及一个返回的整型值
 * 2,实现一个类，类中有一个方法，参数是函数式接口，并且在里面I
 */
package homework.day11;

import homework.day11.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Add add = new Add();
//        Substracts sub = new Substracts();
//        Manipulate mani = new Manipulate();
//        Divided div = new Divided();


        UseCompute c = new UseCompute();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int one = sc.nextInt();
        System.out.println("请输入第二个数");
        int two = sc.nextInt();
        System.out.println("请输入计算方式 ：加 减 乘 除");
        String method = sc.next();
        if ("加".equals(method)) {
            System.out.println(c.useCom((int m, int n) -> one + two, one, two));
        } else if ("减".equals(method)) {
            System.out.println(c.useCom((int m, int n) -> one - two, one, two));
        } else if ("乘".equals(method)) {
            System.out.println(c.useCom((int m, int n) -> one * two, one, two));
        } else if ("除".equals(method)) {
            System.out.println(c.useCom((int m, int n) -> {
                return two == 0 ? 0 : one / two;
            }, one, two));
        }
    }
}
