/**
 * 题目六：
 * 从键盘依次输入10个正整数，存放在数组中，要求编写代码，将整数按照升序增加到数组中（增加是保持升序）
 */
package com.woniuxy.day06;
import java.util.Scanner;

public class TestDemo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int i = 0;
        int size = 0,position = 0;
        for(; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数");
            int num = sc.nextInt();
            
            size++;// 表示有效位数个数；
            boolean is = false;// 判断是否存在比num小的数；
            
            //找到第一个比num小的数的位置；
            for (int j = 0; j < i; j++) {
                if(num <= arr[j]){
                    position = j;
                    is = true;
                    break;
                }
            }
            
            if (is){
                //将后面的数依次往后挪一位；
            for(int k = size -2; k >= position;k--){
                arr[k+1] = arr[k];
            }
            
            //将num放入；
            arr[position] = num;

            } else {
                arr[i] = num;
            }
            
            //遍历此时数组，看是否按升序插入；
            for(int nums:arr){
                System.out.println(nums);
            }
            
            if(i == 10){
                sc.close();
            }
        }
       
    }
    
}
