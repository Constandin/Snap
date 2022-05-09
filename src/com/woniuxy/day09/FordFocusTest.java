/**
 * 题目2：请定义一个小轿车(Car)类，其中有:属性速度speed，其中有方法加速speedUp，减速speedDown，
 * 在测试类TestCar中的main()中实例化一个Car对象，并通过构造方法给它初始化speed值；另外，调用加速，减速的方法对速度进行改变
 */
package com.woniuxy.day09;
import java.util.Scanner;
public class FordFocusTest {
    public static void main(String[] args) {
        System.out.println("进入汽车加速系统");
        Scanner sc = new Scanner(System.in);
        FordFocus myCar = new FordFocus();
        while (true) {
            System.out.println("功能菜单:\n set. 初始化速度\n +. 加速\n -. 减速\n exit. 退出\n");
            String command = sc.next();
            switch (command) {
                case "set":
                    System.out.println("请输入初始速度");
                    int velocity = sc.nextInt();
                    myCar.setSpeed(velocity);
                    System.out.println("初始速度为" + velocity);
                    break;

                case "+":
                    System.out.println("请输入加速速度值");
                    int speedup = sc.nextInt();
                    myCar.speedControl("+",speedup);
                    if (myCar.getSpeed() == 180 ) {
                        System.out.println("超出车辆速度承受范围，请输入 - 以减速");
                    } else if (myCar.getSpeed() >= 185) {
                        System.out.println("车辆损坏，退出系统");
                        System.exit(0);
                    }
                    System.out.println("已加速,当前速度为" + myCar.getSpeed());
                    break;

                case "-":
                    System.out.println("请输入减速速度值");
                    int speeddown = sc.nextInt();
                    myCar.speedControl("-",speeddown);
                    System.out.println("已减速,当前速度为" + myCar.getSpeed());
                    if (myCar.getSpeed() == 0) {
                        System.out.println("车辆已刹停，请输入 + 以加速");
                    }
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    break;

            }
        }
    }
}
