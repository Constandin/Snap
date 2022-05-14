package com.woniuxy.day11;

public abstract class AbstractClass {
    private int num;
    public AbstractClass(){
    }

    public abstract void m1();// 抽象方法；
}
// 不能使用new进行实例化；
// 可以有抽象方法；