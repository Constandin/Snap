/**
 * 题目：输出 9x9 乘法表；
 */
package com.woniuxy.day03;


public class TestDemo15 {
    public static void main(String[] args) {
        for (int i = 1; i < 10;i++){
                for(int j = 1;j <= i;j++){
                    System.out.print(j + "*" + i + "=" + i * j + "\t"); // 注意制表符的使用；
                }   
        System.out.println();
        } 

    }
 
    
}
