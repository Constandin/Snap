package com.woniuxy.day03;
/**
 * 从键盘输入若干学生的某门课成绩，当输入-1时，退出输入，最后计算平均成绩
 */
import java.util.Scanner;
public class TestDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        double sum  = 0,ave = 0;
        while(true){
            System.out.println("请输入第" + i + "学生科目成绩，全部输入完成后重新输入-1以结束");
            double input = sc.nextInt();
            
            if(input == -1){
                break;
            } else {
                
                if(input < 0 || input > 150){
                    System.out.println("请重新输入");
                } else {
                    sum += input;
                    ave = sum / i;
                    i++;
                }
           
            }
        }
        System.out.println(sum + "" + i);
        System.out.println((i-1) + "个学生平均成绩是" + String.format("%.2f",ave));
    sc.close();        
    }
}
