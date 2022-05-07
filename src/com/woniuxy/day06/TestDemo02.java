/**
 * 题目二：
 * 任输入一个数组，以升序排序；(冒泡排序)
 */
package com.woniuxy.day06;
import java.util.Scanner;
public class TestDemo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();
        
        int[] nums = new int[length];
        
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("请输入数组第" + (i + 1) +"个数");
            nums[i] = sc2.nextInt();
            if (i == nums.length){
               sc2.close(); 
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0,temp = 0; j < nums.length - i - 1; j++){
                if (nums[j] > nums[j+1]){
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int arr: nums){
            System.out.println(arr);
        }
        
        sc.close();
        
    }
    
}
