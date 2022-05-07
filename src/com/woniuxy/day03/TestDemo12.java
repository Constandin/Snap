/**
 * 求任意一个正整数的各个位数之和；
 */

package com.woniuxy.day03;
import java.util.Scanner;
public class TestDemo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int integer = sc.nextInt();
        int sum = 0;
        //int i = 1;
        //for(int quotient = integer / 10;quotient != 0;i++){
        //integer = quotient;
        //quotient = integer /10;   
        //}
        //System.out.println(i);输出位数

        for(int quotient = integer / 10;quotient != 0;integer = integer / 10){
            quotient = integer / 10;
            int temp = integer % 10;
            sum += temp;
        }
        System.out.println(sum);
        sc.close(); 
    }
}
