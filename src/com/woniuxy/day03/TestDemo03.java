package com.woniuxy.day03;

public class TestDemo03 {
    public static void main(String[] args) {
        int num = 100;
        int sum = 0;
        
        do {
        sum = num % 10 + (num % 100) / 10 + num / 100;
        if(sum == 12){
            System.out.println(num);
        }
            num++;
        } while (num < 1000);
    
    }
}