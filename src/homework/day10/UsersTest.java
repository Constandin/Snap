/**
 * 1声明一个用户(User)类，属性：account,password,age,重写其equals方法和toString方法
 * 2声明用户操作类，
 * 3声明方法：接收用户数组和一个用户，判断该用户是否存在与数组中，规则是account和password相等
 * 4声明方法：对用户数组排序，规则是age升序
 * 5声明方法：对用户数组遍历输出信息到控制台
 */
package homework.day10;

import java.util.Scanner;
public class UsersTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入用户数据库");
        UsersDatabase u = new UsersDatabase();

        while (true){
            System.out.println();
            System.out.println("请选择功能:\n 1. 存储用户信息\n 2. 查找用户年龄\n 3. 生成用户信息表；\n 4. 退出系统；\n ");
            int option = sc.nextInt();

            Users user = new Users();

            switch (option) {

                case 1:// 存储用户信息；

                        System.out.println("请输入账户名");
                        user.setAccount(sc.next());
                        System.out.println("请输入密码");
                        user.setPassword(sc.next());
                        System.out.println("请输入年龄");
                        user.setAge(sc.nextInt());
                        u.addUsers(user);
                        System.out.println("用户信息已录入");
                        break;


                case 2:// 查找用户；
                    System.out.println("请输入账户名");
                    String account = sc.next();
                    System.out.println("请输入密码");
                    String password = sc.next();
                    System.out.println(u.queryUsers(account,password));
                    break;

                case 3:// 生成用户信息表，即遍历；
                    System.out.println("账户\t\t密码\t\t年龄");
                    u.allUsers(u.nowUsers());
                    break;

                case 4:// 退出系统；
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

    }
}
