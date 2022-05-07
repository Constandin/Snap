package com.woniuxy.day01;

import java.util.Scanner;

public class TestDay01 {
    public static void main(String[] args) { 
        
        int i = 0;
        System.out.println(i-- - --i);

        Scanner in = new Scanner(System.in);
   
        System.out.println("请输入第一个数");
        double num1 = in.nextDouble();

        System.out.println("请输入第二个数");
        double num2 = in.nextDouble();

        if(num1 <= num2){
            System.out.println(num2);
        } else {
            System.out.println(num1);
        }

        System.out.println("请输入一个五位数");
        int num3 = in.nextInt();
        int num4 = num3 % 10;
        int num5 = (num3 % 100) / 10;
        if(num4 == num3/10000 && num5 == (num3 % 10000)/1000){
            System.out.println("该五位数是一个回文数");
        } else {
            System.out.println("该五位数不是一个回文数");
        }
        in.close();
        }
        

}
