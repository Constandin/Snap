/**
 * 题目：在控制台输出五行的星号三角形；
 */
package com.woniuxy.day04;

public class TestDemo02 {
    public static void main(String[] args) {
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4 - i;j++){
                System.out.print("  ");
            }
            for(int j = 0;j < i + 1;j++){
                System.out.print(" * ");
            }
          
        System.out.println();   
        }    
    }
   
}
