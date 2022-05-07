/**
 * 输入一个数组升序排序输出(用快速排序方法)
 */
package com.woniuxy.day06;
import java.util.Scanner;

public class TestDemo10 {
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
        
        int i = 0,temp = 0,min = nums[i];
        for(; i < nums.length - 1;i++){
            for (int j = 1; j < nums.length ; j++){
                if(nums[i] >= nums[j]){
                    min = nums[j];
                    temp = j;//记录最小值的索引；
                } 
            }
            nums[temp] = nums[i];//类似于打擂台，与起始值每一轮对比出来的最小值交换位置；
            nums[i] = min;
        }
        
        for (int arr : nums) {
            System.out.println(arr);
            
        }
    }


    
}
