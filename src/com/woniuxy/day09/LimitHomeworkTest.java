package com.woniuxy.day09;

import java.util.Scanner;

public class LimitHomeworkTest {
    public static void main(String[] args) {
        System.out.println("欢迎进入作业测试，请根据提示选择功能");
        Scanner sc = new Scanner(System.in);

        LimitHomework homework = new LimitHomework();

        while (true) {
            System.out.println();
            System.out.print("请选择菜单\n 1：根据边长计算正方形面积;\n 2：输入年份判断是否是闰年;\n 3：判断是否是质数; \n 4：任输入两个整数组求数组之和;\n 5：退出;\n");
            int option = sc.nextInt();
            switch (option) {

                case 1:
                    System.out.println("请输入正方形边长");
                    double side = sc.nextDouble();
                    System.out.println(side > 0 ? "正方形面积是" + homework.SquareArea(side) : "参数错误，返回");
                    break;

                case 2:
                    System.out.println("请输入年份");
                    int year = sc.nextInt();
                    System.out.println(homework.isLeapYear(year) ? year + "年是闰年" : year + "年不是闰年");
                    break;

                case 3:
                    System.out.println("请输入一个整数");
                    int num = sc.nextInt();
                    if (num > 1) {
                        System.out.println(homework.isPrimeNum(num) ? num + "是质数" : num + "不是质数");
                    } else {
                        System.out.println("参数错误，返回");
                    }
                    break;

                case 4:
                    int length1, length2;

                    //有效性判断；
                    while (true) {
                        System.out.println("请输入第一个数组长度");
                        length1 = sc.nextInt();
                        if (length1 < 0) {
                            System.out.println("数组长度不能小于0，请重新输入");
                        } else {
                            break;
                        }
                    }

                    //输出数组1
                    int[] arr1 = homework.outArray(length1);

                    //有效性判断；
                    while (true) {
                        System.out.println("请输入第二个数组长度");
                        length2 = sc.nextInt();
                        if (length2 < 0) {
                            System.out.println("数组长度不能小于0，请重新输入");
                        } else {
                            break;
                        }
                    }

                    // 输出数组2；
                    int[] arr2 = homework.outArray(length2);

                    // 调用方法求数组值和；
                    int[] newArr = homework.addArr(arr1, arr2);

                    if (Math.max(length1, length2) == 0) {
                        System.out.println();
                        System.out.println("两个数组为空数组，求和后仍为空数组");
                    } else {
                        System.out.println();
                        System.out.println("两个数组之和为");
                        for (int addArr : newArr) {
                            System.out.print(addArr + "\t");
                        }
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
}
