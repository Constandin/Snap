/**
 * 找出数组中重复出现的元素
  如:{1,2,3,4,2,4,2,5,6}  得到2,4
 */
package com.woniuxy.day06;
import java.util.Scanner;
public class TestDemo08 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();

        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++){
            System.out.println("请输入数组第" + (i + 1) + "个数");
            nums[i] = sc.nextInt();
            if (i == nums.length) {
                sc.close();
            }
        }

        
        for (int i = 0; i < nums.length - 1; i++){
        // 放在内部用来重置布尔变量；    
            boolean is = false;
        // k用来计次 -- nums[i]后面的所有数中与nums[i]相等的个数；    
            int k = 0;
        // 检验nums[i]以后的所有数中是否有与nums[i]相等的数；
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums [j]){
                k++;
        // 将相同的数依次与nums[i]以后与nums[i]不等的数交换位置；        
                int temp = nums[i + k]; 
                nums[i + k] = nums[j];
                nums[j] = temp;
                is = true;
                }
            }
        // 将布尔变量用作输出的重复元素的指标；
            if(is){
                System.out.println(nums[i] + "为重复元素");
            }
        // 跳过重复元素，避免重复输出；
            i = i + k;

        }


    }
    
    
    
}
