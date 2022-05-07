package com.woniuxy.day02;
import java.util.Scanner;
public class Testday02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一到七任意一个汉字");
        String s = sc.next();
      if(s.equals("一")){
          s = "Monday";
      } else if(s.equals("二")){
          s = "Tuesday"; 
      } else if(s.equals("三")){
          s = "Wednesday";
      } else if(s.equals("四")){
          s = "Thursday";
      } else if(s.equals("五")){
          s = "Friday";
      } else if(s.equals("六")){
          s = "Saturday";
      } else if(s.equals("七")){
          s = "Sunday";
      } else {
          System.out.println("长点脑子");
      }
      System.out.println(s);
    sc.close();
    }    
}

