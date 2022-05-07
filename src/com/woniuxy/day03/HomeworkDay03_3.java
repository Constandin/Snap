/**
 * 题目三：输入三个整数xyz，并按从小到大顺序输出；
 * 日期:20220426；
 */

package com.woniuxy.day03;
import java.util.Scanner;
public class HomeworkDay03_3 {
    public static void main(String[] args) {
    int mid;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("请输入第一个数");
    int x = sc.nextInt();

    System.out.println("请输入第二个数");
    int y = sc.nextInt();

    System.out.println("请输入第二个数");
    int z = sc.nextInt();
    
    if (x >= y) {mid = y;y = x;x = mid;}
    if (y >= z) {mid = z;z = y;y = mid;}
    if (x >= y) {mid = y;y = x;x = mid;}

    System.out.println(x + "" + y + "" + z);
    sc.close();
        }
        
    }



