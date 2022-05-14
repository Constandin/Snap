/**
 * 利用接口做参数，写个计算器，能完成加减乘除运算
 * (1)定义一个接▣Computable含有一个方法int computer(int n,int m)
 * (2)设计四个类分别实现此接口，完成加减乘除运算。
 * (3)设计一个类UseCompute,类中含有方法：public int useCom(Computable com,int one,int two),此方法能够用传递过来的对象
 * 调用computer方法完成运算，并输出运算的结果。
 * (4)设计一个主类Test,调用UseCompute中的方法useCom来完成加减乘除运算，
 */
package homework.day11;

public class UseCompute {
    public int useCom(Calculator com,int one,int two){
        return com.computer(one,two);
    }
}
