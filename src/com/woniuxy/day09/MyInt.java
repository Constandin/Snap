package com.woniuxy.day09;

public class MyInt {
    public static void main(String[] args) {
        WrapDemo myInt = new WrapDemo(10);
        System.out.println(myInt.getValue());  //10
        myInt.setValue(20);
        System.out.println(myInt.getValue());  //20
    }
}