/**
 * 题目三：
 * 给定一个整数，从键盘输入整数，比较它与前面给定的整数之间的大小，并给出提示，直到猜对为止，输出猜了多少次。
 */

package com.woniuxy.day06;
import java.util.Scanner;

public class TestDemo03 {
    public static void main(String[] args) {
        
        int num = 50,i = 0;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("请输入一个数");
            int input = sc.nextInt();
            i++;
            if(input > num){
                System.out.println("大了，请重新输入！");
            } else if(input < num) {
                System.out.println("小了，请重新输入！");
            } else {
                System.out.println("对了，恭喜");
                break;
            }

        }
        System.out.println("您总共猜了" + i + "次");
        sc.close();
                
    }
    
}
