/**
 * 题目四：
 * 企业发放的奖金根据利润提成。
 * 利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？
 * 
 * 日期:20220426；
 */
package com.woniuxy.day03;

import java.util.Scanner;

public class HomeworkDay03_4 {
    public static void main(String[] args) {
        int bonus;
        final int level1 = 100000 * 10 / 100;
        //利润为10万元的分红；
        final int level2 = 100000 * 75 / 1000 + 100000 * 10 / 100;
        //利润超过20万，20万以内部分的分红；
        final int level3 = 200000 * 5 / 100 + 100000 * 75 / 1000 + 100000 * 10 / 100;
        //利润超过40万，40万以内部分的分红；
        final int level4 = 200000 * 3 / 100 + 200000 * 5 / 100+100000 * 75 / 1000 + 100000 * 10 / 100;
        //利润超过60万，60万以内部分的分红；
        final int level5 = 400000 * 15 /1000 + 200000 * 3 / 100 + 200000 * 5 / 100+100000 * 75 / 1000 + 100000 * 10 / 100;
        //利润超过100万，100万以内部分的分红；

        Scanner sc = new Scanner(System.in);
        
        System.out.println("请输入利润");
        int profit = sc.nextInt();

        if(profit <= 0){
            bonus = 0;
        } else if (profit <= 100000){
            bonus = profit * 10 /100;
        } else if (profit <= 200000){
            bonus = (profit - 100000) * 75 / 1000 + level1;
        } else if (profit <= 400000){
            bonus = (profit - 200000) * 5 / 100 + level2;
        } else if (profit <= 600000){
            bonus = (profit - 400000) * 3 / 100 + level3;
        } else if (profit <= 1000000){
            bonus = (profit - 600000) * 15 / 1000 + level4;
        } else {
            bonus = (profit - 1000000) * 1 / 100 + level5;
        }
        
        System.out.println("您的分红是" + bonus);

        sc.close();  
    }
}
