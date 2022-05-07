package com.woniuxy.day01;

import java.util.Scanner;
public class Homework01 {
public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入一个整数");
    int num1 = sc.nextInt();
    if(num1 >= 100 && num1 <= 999){
        System.out.println("这是一个三位数");
    } else {
        System.out.println("这不是一个三位数");
    }
    
    System.out.println("请输入第一个正整数");
    int num2 = sc.nextInt();
    System.out.println("请输入第二个正整数");
    int num3 = sc.nextInt();
    System.out.println("请输入第三个正整数");
    int num4 = sc.nextInt();
    if(num2 + num3 > num4 && num3 + num4 >num2 && num2 + num4 > num3 ){
    System.out.println("以三个整数作为三条边边长可以组成三角形");
    } else {
        System.out.println("以三个整数作为三条边边长不可以组成三角形");
    }

    System.out.println("请输入一个年份");
    int num5 = sc.nextInt();
    if((num5 % 4  == 0 && num5 % 100 != 0 ) || num5 % 400 == 0 ){
        System.out.println("这是一个闰年");
    } else {
        System.out.println("这不是一个闰年");
    } 

    sc.close();
}
    
}
