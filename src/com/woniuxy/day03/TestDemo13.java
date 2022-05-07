package com.woniuxy.day03;
/**
 * 计算1-2+3-4+5-6…..+99-100的值
 */
public class TestDemo13 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1;i <= 100;i++ ){
            int a;
            if(i % 2 == 0){
                a = -i;
            } else{a = i;} 
            sum += a;
        }  
        System.out.println(sum);
    }
}
