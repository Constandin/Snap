/**
 * 1-50 5的倍数相乘
 */
package com.woniuxy.day03;

public class TestDemo09 {
    public static void main(String[] args) {
      long result = 1;
      for (int i = 5; i <= 50;i = i +5){
          result = result * i;
      }
      System.out.println(result);  
    }
}
