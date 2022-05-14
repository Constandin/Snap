/**
 * 1声明一个用户(User)类，属性：account,password,age,重写其equals方法和toString方法
 * 2声明用户操作类，
 * 3声明方法：接收用户数组和一个用户，判断该用户是否存在与数组中，规则是account和password相等
 * 4声明方法：对用户数组排序，规则是age升序
 * 5声明方法：对用户数组遍历输出信息到控制台
 */
package homework.day10;
public class Users {
    private String account;
    private String password;
    private int age;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // to String 方法
    public String toString(Users user) {
        return user.getAccount() + "\t\t" + user.getPassword() + "\t\t"  + user.getAge();
    }
}
