/**
 * 课堂任务：
 * 实现账号抽象类(AbstractAccount),其中声明一个属性余额(money),使用两个方法：不可重写的方法getMoney().
 * 第二个方法计算利息的抽象方法
 * 声明两个账号类（话期和定期），实现计算利息，通过父类的getMoney得到多少;
 * 课堂任务：
 * 实现账号抽象类(AbstractAccount),其中声明一个属性余额(money),使用两个方法：不可重写的方法getMoney().
 * 第二个方法计算利息的抽象方法
 * 声明两个账号类（话期和定期），实现计算利息，通过父类的getMoney得到多少;
 */
package homework.day12.calmoney;

public abstract class Account {
    private double money;
    private int year;
    public Account(double money,int year){
        this.money = money;
        this.year = year;
    }

//核心逻辑用final修饰 不可更改
    public final double getMoneyAndInterest() {
        return this.money + getInterest(year);
    }

    public double getMoney(){
        return this.money;
    }

    public abstract double getInterest(int year);
}
