/**
 * 判断某个给定的整数是否是质数
 */

package com.woniuxy.day03;

public class TestDemo11 {
    public static void main(String[] args) {
        double a = 2.0,b = 1.0;
        double temp;
        double sum = 0;
        for(int i = 1;i <= 10;i++){
        double j = a/b;
        sum = sum + j;
        temp = a;
        a = a + b;
        b = temp; 
     }
     
     System.out.println(sum);
    
    
     }
}
