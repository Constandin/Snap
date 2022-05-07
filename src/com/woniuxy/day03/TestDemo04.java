package com.woniuxy.day03;

public class TestDemo04 {
    public static void main(String[] args) {
        for (int num =100,sum = 0;num < 1000;num++){
            sum = num % 10 + (num % 100) / 10 + num / 100;
            if (sum == 12){
                System.out.println(num);
            } 
        }
    }
}