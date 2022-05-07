/**
 * 题目：
 * 将数组的元素翻倍；
 * 将数组反转；
 */
package com.woniuxy.day05;

import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();

        int[] nums = new int[length];
        int i = 0, j = 0, k = 0, temp = 0;
        
    
        for (; i < nums.length; i++) {
            
            System.out.println("请输入第" + (i + 1) + "个整数");
            nums[i] = sc.nextInt();
            if (i == nums.length) {
                sc.close();
            }
        }
        // 为数组每一位赋值；
        
        for(;j <nums.length; j++) {
            nums[j] *= 2;
        }
        
        for(; k < nums.length / 2; k++) {
            temp = nums[k];
            nums[k] = nums[nums.length - 1 -k];
            nums[nums.length - 1 -k] = temp;
        }

        for(int num:nums){
            System.out.println(num);
        }
        sc.close();
        
    }

}
