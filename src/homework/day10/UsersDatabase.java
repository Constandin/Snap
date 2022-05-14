package homework.day10;
//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class UsersDatabase {

    // 以升序添加对象方法；
    Users u = new Users();
    private ArrayList<Users> users = new ArrayList<>();

    public void addUsers(Users user) {

        users.add(user);

        // TODO:检查异常值；



        // 检查重复值；
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < i; j++) {
                Users newUser = users.get(i);
                Users preUser = users.get(j);

                if (newUser.getAccount().equals(preUser.getAccount())
                        && newUser.getPassword().equals(preUser.getPassword())
                        && newUser.getAge() == preUser.getAge()) {
                    users.remove(i);
                    System.out.println("用户重复，请重新输入");
                    break;
                }
            }
        }

        // 以年龄升序排序；
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                Users oldUser = users.get(j);
                Users youngUser = users.get(j + 1);
//                Users tempUser;
                if (oldUser.getAge() > youngUser.getAge()) {
//                    tempUser = youngUser;
//                    youngUser = oldUser;
//                    oldUser = tempUser; 没必要！
//                    users.set(j + 1, oldUser);
//                    users.set(j, youngUser);
                    Collections.swap(users,j,j + 1);
                }
            }
        }
    }


    // 获取对象数组；
    public ArrayList<Users> nowUsers(){
        return users;
    }

    // 查询对象方法；
    public String queryUsers(String account, String password) {
        boolean isExist = true;
        int temp = 0;
        int i = 0;
        if(users.size() == 0){return "无用户,请先存储用户信息";}

        for (; i < users.size() ; i++) {
            Users queryUser = users.get(i);
            // 判断账户、密码是否匹配；
            if (account.equals(queryUser.getAccount()) && password.equals(queryUser.getPassword())) {
                temp = i;
                isExist = true;
                break;
            } else {
                isExist = false;
            }

        }
        Users queryUser = users.get(temp);
        return  isExist ? (account + "的年龄是" + queryUser.getAge()) : " 用户名或密码输入错误，请重新输入";
    }


    // 遍历方法
    public void allUsers(ArrayList<Users> users) {
        if(users.size() == 0 ){
            System.out.println("账户信息为空");
        }
        for (int i = 0; i < users.size() ;i++){
            Users user = users.get(i);
            System.out.println(u.toString(user));
        }
    }

}

