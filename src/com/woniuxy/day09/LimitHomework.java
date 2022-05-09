package com.woniuxy.day09;

import java.util.Scanner;

public class LimitHomework {

    //求正方形面积平方；
    public String SquareArea(double side) {
        double squareArea = Math.pow(side, 2);
        return String.format("%.2f", squareArea);
    }

    //判断闰年；
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;//判断闰年；
    }

    //判断给定整数是不是一个质数；
    public boolean isPrimeNum(int num) {
        boolean judge = true;// 标识变量；

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                judge = false;
                break;
            }
        }

        return judge;
    }

    //输入数组
    public int[] outArray(int length) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[length];

        if (length == 0) {
            System.out.println("此数组为空数组");
        } else {
            for (int i = 0; i < length; i++) {
                System.out.println("请输入第" + (i + 1) + "个整数");
                arr[i] = sc.nextInt();
            }

        }

        return arr;
    }

    //计算两个数组之和；
    public int[] addArr(int[] arr1, int[] arr2) {
        int maxLength = Math.max(arr1.length, arr2.length);
        int[] newArr = new int[maxLength];

        if (arr1.length <= arr2.length) {
            for (int i = 0; i < maxLength; i++) {
                newArr[i] = i < arr1.length ? arr1[i] + arr2[i] : arr2[i];
            }
        } else {
            for (int i = 0; i < maxLength; i++) {
                newArr[i] = i < arr2.length ? arr1[i] + arr2[i] : arr1[i];
            }
        }

        return newArr;
    }
}
