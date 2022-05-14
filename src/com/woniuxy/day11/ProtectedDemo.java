/**
 * public：范围最大，修饰类，方法，属性，所有的代码都可以访问到
 *
 * protected：受保护的，修饰内部类，本类代码可以访问，本包可以访问，在子类中访问到（从继承 角度）
 *
 * 默认的：没有关键字，修饰类，属性，方法，只有同一个包中的代码可以访问到
 *
 * private：范围最小，修饰内部类，方法，属性，本类中的代码可以访问到，private体现了OOP中封装的特点
 */
package com.woniuxy.day11;

public class ProtectedDemo {
    protected int num1 ;
}

class Test{
    public void text(ProtectedDemo p,DefaultDemo d){
        p.num1 = d.num2;
    }
}

