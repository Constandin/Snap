package com.woniuxy.day10;

public class Son extends Parent {
    public static void main(String[] args) {
        // java只支持单继承，如果父类方法是static，可以直接调用；
        // 若父类方法非静态，子类需创建对象；
        Son son = new Son();
       int[] arr = {1,2,3,4};
       System.out.println(son.evenNumEqual(arr));
    }
}
