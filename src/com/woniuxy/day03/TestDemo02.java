package com.woniuxy.day03;

public class TestDemo02 {
    public static void main(String[] args) {
        int i = 100;
        int sum = 0;
        while (i < 1000 ) {
            boolean judge = i % 7 == 0 || i / 100 == 7 || (i % 100) / 10 == 7 || i % 10 == 7;
            if(judge){
                sum += i ; 
            }
                i++;
            }
            System.out.println(sum);
        }
        
    }


