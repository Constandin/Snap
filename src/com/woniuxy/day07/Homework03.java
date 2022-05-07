/**
 * 判断两个数组中的偶数个数是否相等；
 */
package com.woniuxy.day07;
import java.util.Scanner;
public class Homework03 {
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);
        
        System.out.println("请输入数组1长度");
        int length1 = sc1.nextInt();
        int[] arr1 = outArray(length1);
        int i = evenNumEqual(arr1);

        
        System.out.println("请输入数组2长度");
        int length2 = sc1.nextInt();
        int[] arr2 = outArray(length2);
        int j = evenNumEqual(arr2);
        
        if(isEvenNumEqual(i,j)){
            System.out.println("两个数组偶数个数相同");
        } else {
            System.out.println("两个数组偶数个数不同");
        }
        
        sc1.close();

    }
    // 方法 -- 输出数组；
    public static int[] outArray(int length){
        Scanner sc2 = new Scanner(System.in);
        int[] arr = new int[length];
            for (int i = 0; i < length; i++){
                System.out.println("请输入第" + (i + 1)  + "个整数");
                arr[i] = sc2.nextInt();
                if (i == arr.length) {
                    sc2.close();
                }
            }

        return arr;
    
    }
    
    // 方法 -- 输出数组偶数个数；
    public static int evenNumEqual (int[] arr){
        int i = 0,j = 0;
        for (; i < arr.length; i++){
            if((arr[i] % 2) == 0){
                j++ ;
            }
        }
        return j;
    }
    
    //对比偶数个数是否相等；
    public static boolean isEvenNumEqual (int i,int j){
        return i == j;
    }



}
