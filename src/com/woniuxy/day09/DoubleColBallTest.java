/**
 * 产生双色球的数列：红色球随机产生1-33之间的6个不重复的整数，蓝色球随机产生1个1-16之间的整数，编写方法用于产生双色球的7个整数;
 */
package com.woniuxy.day09;

import java.util.Scanner;

public class DoubleColBallTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入双色球选号系统");
        DoubleColBall luckyCode = new DoubleColBall();

        while (true) {
            System.out.println();
            System.out.println("功能菜单:\n" + "1. 当日幸运号码\n" + "2. 退出双色球选号系统");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("当日幸运号码是");
                    for (int dayCode : luckyCode.codeLottery()) {
                        System.out.print(dayCode + "\t");
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("系统已退出");
                    System.exit(0);
                    break;

                default:
                    break;

            }
        }
    }
}
