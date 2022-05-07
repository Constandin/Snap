/**
 * 根据圆半径计算周长；
 */
package com.woniuxy.day07;
import java.util.Scanner;

public class Homework01 {
    // 方法 -- 周长计算；
    public static double calPerimeter(double radius){
        return 2 * radius * Math.PI;    
    }
        
    // 方法 -- 保留两位小数；
    public static String cirPerimeter(double perimeter){
        return String.format("%.2f",perimeter);
    }    
    
    // 主方法 -- 程序入口；
    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);      
        while(true){
            System.out.println("请输入圆的半径");
            double radius = sc.nextDouble();
            if(radius >= 0){          
                
                //接收方法返回值；
                double perimeter = calPerimeter(radius);
                
                //保留两位小数
                System.out.println(cirPerimeter(perimeter));
    
            } else {
    //判断输入值无效情况；
                System.out.println("错误");
                break;
            }
    
        }
       
    sc.close();
    }
    

}   
