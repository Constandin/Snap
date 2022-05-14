/**
 * (1)定义一个抽象类Weapon,该抽象类有两个抽象方法attack0,move0:这两个方法分别表示武器的攻击方式和移动方式。
 * (2)定义3个类：Tank,Flighter,,WarShip都继承自Weapon,分别用不同的方式实现Weapon类中的抽象方法。
 * (3)写一个类Army,代表一支军队：
 * 这个类有一个属性是Weapon数组w(用来存储该军队所拥有的所有武器)：
 * 该类还提供一个构造方法，在构造方法里通过传一个it类型的参数来限定该类所能拥有的最大武器数量，并用这一大小来初始化数组w。
 * 该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组W中。
 * 在这个类中还定义两个方法attackAll(O和moveAll(),让w数组中的所有武器攻击和移动。
 * (4)写一个主方法去测试以上程序。
 */
package com.woniuxy.day11.classtask;

public abstract class Weapon {
    public abstract void attack0();// 抽象方法必须放到抽象类里；
    public abstract void move0();
//    private
//    public Weapon(){
//
//    }
}
