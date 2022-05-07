/**
 * 获取整型数组元素中位数；
 */
package com.woniuxy.day07;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int length = sc.nextInt();

        int[] arr = new int[length];
        if (length <= 0){
            System.out.println("输入错误，结束");

        } else {
            for (int i = 0; i < length; i++){
                System.out.println("请输入第" + (i + 1)  + "个整数");
                arr[i] = sc.nextInt();
            }
        }
        System.out.println("该数组中位数是" + getMedian(bubleSort(arr)));
        sc.close();
    }
    
    public static int[] bubleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0,temp = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;    
    }
    
    public static int getMedian(int[] arr) {
        return arr.length % 2 == 0 ? (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2 : arr[arr.length / 2];
        
    }
}
