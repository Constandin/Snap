/**
 * 题目：输出星号空心正方形；
 */
package com.woniuxy.day04;
import java.util.Scanner;

public class TestDemo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入正方形边长");
        int width = sc.nextInt();

        
        for (int x = 1;x <= width;x++){
            for(int y = 1;y <= width;y++){
                if(x == 1 || y == 1 || x == width || y == width){
                    System.out.print(" *");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}