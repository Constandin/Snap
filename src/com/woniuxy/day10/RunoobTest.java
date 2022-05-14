package com.woniuxy.day10;

public class RunoobTest {
    public static void main(String[] args) {

        // Object 类使用 equals() 方法
        // 创建两个对象
        Object obj1 = new Object();
        Object obj2 = new Object();

        // 判断 obj1 与 obj2 是否相等
        // 不同对象，内存地址不同，不相等，返回 false
        System.out.println(obj1.equals(obj2)); // false

        // obj1 赋值给 obj3
        // String 重写了 equals() 方法
        // 对象引用，内存地址相同，相等，返回 true
        Object obj3 = obj1;
        System.out.println(obj1.equals(obj3)); // true


        //字符串equals，String重写了equals方法，比较字符串的内容；
        //对象equals，String比较的是对象地址；
    }
}
