package com.woniuxy.day02;
import java.util.Scanner;
public class Calender {
    public static void main(String[] args) {
    int days;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("请输入年份");
    int year = sc.nextInt();

    System.out.println("请输入月份");
    int month = sc.nextInt();

    boolean isLeapYear = year % 4  == 0 && year % 100 != 0 || year % 400 == 0 ;//判断闰年；
    
    if (month > 12 || month < 0) {
        System.out.println(year + "年" + month + "月为无效数据");//判断数据有效性；
    } else {
        //判断是否是小月；
        if(month == 4 || month == 6 || month == 9 || month == 11){
            days = 30;
        } else if (month == 2){
            //判断是否是二月；
            if(isLeapYear){
                days = 29;
            } else {
                days = 28;
            }
        } else {
            //大月的情况；
            days = 31;
        }
    System.out.println(year + "年" + month + "月有" + days + "天");
        
    }
 sc.close();
    }
}


