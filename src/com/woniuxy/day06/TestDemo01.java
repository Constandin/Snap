/**
 * 题目一：
 * 判断两个数组是否相等;
 * 将一个数组的奇数索引位拷贝到另一个数组中前半部分，偶数索引位数字拷贝到后半部分;
 */
package com.woniuxy.day06;

import java.util.Scanner;

public class TestDemo01 {
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
        //判断长度是否相等；
        if (length1 == length2) {
        //若长度相等，进行循环判断是否每一个元素相等；
            for (;k < nums1.length;k++){
                if(nums1[k] != nums2[k]){
                    is = false;
                    break;
                }
            }
        } else {
        //长度不相等，直接输出false；    
            is = false;
        }
        
        if(is){
            System.out.println("数组1与数组2相等");
        } else {
            System.out.println("数组1与数组2不相等");
        }
    
        
        if (length1 <= length2){
        //如果数组1长度小于数组2，将1的值拷贝入2中；   
            for (int m = 1,n = 0; m < nums1.length; m += 2,n++){
         //将数组1的奇数索引位拷入数组2的前半部分；
                nums2[n] = nums1[m];
            }
            for (int m = 0,n = nums2.length / 2; m < nums1.length; m += 2,n++){
            //将数组1的偶数索引位拷入数组2的后半部分；
                nums2[n] = nums1[m];

            }
        } else {
        //如果数组2长度小于数组1，将2的值拷贝入1中；  
            for (int m = 1,n = 0; m < nums2.length; m += 2,n++){
        //将数组2的奇数索引位拷入数组1的前半部分；
                nums1[n] = nums2[m];
            }
            for (int m = 0,n = nums1.length / 2; m < nums2.length; m += 2,n++){
        //将数组2的偶数索引位拷入数组1的后半部分；
                nums1[n] = nums2[m];

        }
    }
    for(int arr1:nums1){
        System.out.println("arr1" + "\n" + arr1);
    }

    for(int arr2:nums2){
        System.out.println("arr2" + "\n" + arr2);
    }
    }
}
