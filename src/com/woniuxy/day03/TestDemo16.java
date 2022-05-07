/**
 * 计算 100 以内整数和，当值大于500时中止；
 */
package com.woniuxy.day03;
public class TestDemo16 {
    public static void main(String[] args) {
        int sum = 0,i = 1;
        for (; i <= 100; i++) {
            sum += i;
            if (sum > 500) {
                break;
            }
        } 
    System.out.println(sum);  
    System.out.println(i);    
    }
    
    
}
