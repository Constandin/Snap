/**
 * 判断某个给定的整数是否是质数
 */

 package com.woniuxy.day03;
import java.util.Scanner;
public class TestDemo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int integer = sc.nextInt();
        boolean judge = true;// 标识变量；
        for(int i =2;i < integer;i++){
            if (integer % i == 0){
                judge = false;
                break;
            }    
        }
        if(judge){
            System.out.println("这是一个质数");
        } else {
            System.out.println("这不是一个质数");
        }
        sc.close();
    }  
}
