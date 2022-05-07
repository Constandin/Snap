/**
 * 题目九：
 * 判断一个数组中是否包含另一个数组
 * 如：{1,2,3,4,5,6} 包含{3,4}  但不包含{3,4,6}  {1,2,3,4,5,6,7}
 */
package com.woniuxy.day06;
import java.util.Scanner;

public class TestDemo09 {
    public static void main(String[] args) {
        int i = 0, j = 0, k = 0;
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入第一个数组长度");
        int length1 = sc1.nextInt();
        int[] nums1 = new int[length1];

        for (; i < nums1.length; i++) {
            System.out.println("请输入数组1的第" + (i+1) + "个整数 ");
            nums1[i] = sc1.nextInt();
            if (i == nums1.length){
                sc1.close();
            }
        }
        
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入第二个数组长度");
        int length2 = sc2.nextInt();
        int[] nums2 = new int[length2];
        
        for (; j < nums2.length; j++) {
            System.out.println("请输入数组2的第" + (j+1) + "个整数 ");
            nums2[j] = sc2.nextInt();
            if (j == nums2.length){
                sc2.close();
            }
        }

        boolean is = true;
        if (length1 >= length2) {
            for (;k < (nums1.length - nums2.length) + 1;k++){
        //判断数组2如在数组1中的起始位置的所有可能性；
                for(int m = k,n = 0;n < nums2.length;m++,n++){
                    
                    if(nums1[m] != nums2[n]){
                        is = false;
                        break;
                    } else {
                        is = true;
                    }
                
                }   
            }
        } else {
            is = false;
        }
        
        if(is){
            System.out.println("数组2在数组1中");
        } else {
            System.out.println("数组2不在数组1中");
        }   
    
}
}