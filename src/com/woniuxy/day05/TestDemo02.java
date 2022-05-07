/**
 * 判断一个int数据是否在一个int数组中;
 */
package com.woniuxy.day05;
import java.util.Scanner;
public class TestDemo02 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();
        
        int i = 0,j = 0;
        int[] nums = new int[length];
        
        for(; i < nums.length; i++){
            
            System.out.println("请输入长度为" + length +"的数组第" + (i+1) + "个整数");
            nums[i] = sc.nextInt();
             
            if (i == nums.length){
                sc.close();
            }
        }

        Scanner test = new Scanner(System.in);
        System.out.println("请输入测试数据");
        int testInt = test.nextInt();
        
        
        boolean is = false;
        for(; j < nums.length; j++){
           
            if (testInt == nums[j]){
               is = true;
               test.close();
               break;
            }
        
        }
        
        if (is){
            System.out.println("测试数据是生成数组内第" + (j + 1) + "个数");
        } else {
            System.out.println("测试数据不等于生成数组内任意一个数");
        }
        

        }

    }
