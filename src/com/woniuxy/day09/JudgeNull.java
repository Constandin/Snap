package com.woniuxy.day09;
import java.util.Scanner;

public class JudgeNull {
    public static boolean judgeNull(String characters) {
        if (characters == null){
            return true;
        } else return characters.trim().equals("");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        System.out.println("请输入");
        String input = sc.next();


        boolean isNull = judgeNull(input);
        System.out.println(isNull ? "Null" : "!Null");
    }

}