/**
 * 找出1000之间的水仙花数；
 */
package com.woniuxy.day03;

public class TestDemo07 {
    public static void main(String[] args) {
        
        for(int i = 100;i <= 999;i++){
            int num = i;
            for(int ones = i % 10,tens = (i % 100)/10,hundreds = i / 100;
            num == ones * ones *ones + tens * tens * tens + hundreds * hundreds * hundreds && num <= 999;
            num++
            ){
                System.out.println(num); 
            } 
        }
    }
}
