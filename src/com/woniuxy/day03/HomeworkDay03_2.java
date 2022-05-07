/**
 * 题目二：输入一个三位数是否含7或是7的倍数；
 * 日期:20220426；
 */
package com.woniuxy.day03;
import java.util.Scanner;
public class HomeworkDay03_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入一个三位整数");
        int integer = sc.nextInt();
        
        boolean judge = (integer % 7 == 0 || integer / 100 == 7 || (integer % 100) / 10 == 7 || integer % 10 == 7);
        if (integer >= 100 && integer <= 999){
            if(judge) {
                System.out.println("该三位数是7的倍数或含7");
            } else{
                System.out.println("该三位数不是7的倍数且不含7");
            }
        } else {
            System.out.println("无效数据");
        }
       
        sc.close();
    }
}
