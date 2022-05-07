package com.woniuxy.day04;

//找出一个int数组中的最大值；
import java.util.Scanner;

public class TestDemo01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();

        int[] nums = new int[length];
        int i = 0, j = 0, k = 0, temp = 0;
        boolean is = true;

        for (; i < nums.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数");
            nums[i] = sc.nextInt();
            if(i == nums.length) {
                sc.close();
            }
        }
        // 为数组每一位赋值；
        

        for (int num : nums) {
            System.out.println(num);
        }
        // 遍历数组每一位数；

        for (; j < nums.length; j++) {
            for (; k < nums.length; k++) {
                
                is = nums[j] >= nums[k];

                if (!is) {
                    break;
                } else {
                    temp = j;
                }
            
            }
        }
        System.out.println("该数组最大值为" + nums[temp]);
        
        
        
        sc.close();
    }

}
