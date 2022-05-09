/**
 * 编写Java程序，模拟简单的计算器定义名为MyComputer的类，其中有两个整型数据成员n1和n2。
 * 编写构造方法，赋予n1和n2初始值，再为该类定义加（addition）、减（subtraction）乘（multiplication）、除（division）等公有成员方法，分别对两个成员变量执行加、减、乘、除的运算。在该类的main方法中创建MyComputer类的对象，调用各个方法，并显示计算结果
 */
package com.woniuxy.day09;

import java.util.Scanner;

public class MyComputer {
    private int n1;
    private int n2;

    public MyComputer(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入计算器");
        while (true) {

            System.out.println("请输入第一个数");
            int num1 = sc.nextInt();
            System.out.println("请输入第二个数");
            int num2 = sc.nextInt();
            MyComputer result = new MyComputer(num1, num2);
            System.out.println("请选择功能:\n 1. 加法;\n 2. 减法;\n 3. 乘法;\n 4. 除法;\n 5. 退出;\n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    result.addition();
                    break;
                case 2:
                    result.subtraction();
                    break;
                case 3:
                    result.multiplication();
                    break;

                case 4:
                    if (num2 == 0) {
                        System.out.println("除数不能为零，请重新输入");
                    } else {
                        result.division();
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    break;
            }

        }

    }

    public void addition() {
        System.out.println(n1 + n2);
    }

    public void subtraction() {
        System.out.println(n1 - n2);
    }

    public void multiplication() {
        System.out.println(n1 * n2);
    }

    public void division() {
        System.out.println(n1 / n2);
    }

}
