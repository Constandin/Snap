/**
 * 题目七：
 * 已知周一是1900年1月1号，请从键盘输入年份和月份，输出其月历
 * 如：2019  7  输出
 * 日  一  二  三  四  五  六
 *     1   2   3   4   5   6
 * 7   8   9   10  11  12  13
 * 14  15  16  17  18  19  20
 * 21  22  23  24  25  26  27
 * 28  29  30  31
 */
package com.woniuxy.day06;
import java.util.Scanner;
public class TestDemo07 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = sc.nextInt();
        System.out.println("请输入月份");
        int mon = sc.nextInt();
        System.out.println("日"+"\t"+"一"+"\t"+"二"+"\t"+"三"+"\t"+"四"+"\t"+"五"+"\t"+"六");
        sc.close();
        

        int temp = 0;
        // 判断闰年,非整百年份是四的倍数是闰年，整百年份是四百的倍数为闰年；
        boolean LeapYear = year % 4  == 0 && year % 100 != 0 || year % 400 == 0 ;
        // 判断输入年份之前闰年个数；
        for(int i = 1900; i < year; i++){
            if(i % 4  == 0 && i % 100 != 0 || i % 400 == 0){
                temp = temp + 1;
            }
        }
        

        int prev = temp * 366 + (year - 1900 - temp ) * 365;
        int days = 0, sum = 0, thisMon = 31;
        // 闰年各月天数；
        int[] isLeapYear= {31,29,31,30,31,30,31,31,30,31,30,31};
        // 非闰年各月天数；
        int[] notLeapYear= {31,28,31,30,31,30,31,31,30,31,30,31};
        
        // 输入年度当年输入月份前的总计天数，例：如是输入5，及计算当年1-4月的天数；
        if(LeapYear){
            for (int i = 0; i < mon - 1 ; i++){
                sum += isLeapYear[i];
                thisMon = isLeapYear[mon - 1];
            }
        } else {
            for (int i = 0; i < mon - 1 ; i++){
                sum += notLeapYear[i]; 
                thisMon = notLeapYear[mon - 1];
            }
        }
        
        days = sum + prev;
        // 总天数等于输入年份前一年的12月31日到1900年1月1日与当年总计天数之和；
        int weekDay = (days + 1) % 7;
        // 计算输入当月的第一天是周几；
        int j,k;
        
        for ( j = 0; j < weekDay; j++){
            System.out.print("" + "\t");
        } 
        
        for( k = 1; k <= thisMon; k++){ 
            System.out.print(k + "\t");
        // 每输入其次执行换行一次；
            if ((k + j) % 7 == 0){
                System.out.println();
            }
        }
  }
}
