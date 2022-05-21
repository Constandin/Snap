package com.woniuxy.chess.service;

import com.woniuxy.chess.dao.UserDao;
import com.woniuxy.chess.entity.User;
import com.woniuxy.chess.global_config.Global;

import java.sql.SQLException;
import java.util.Objects;


public class UserService {
    //返回0  登陆成功
    //返回1  账号不存在
    //返回2  密码错误
    //返回3  密码为空
    //返回4  账号为空
    public int signIn(String accound, String password) throws Exception {
        UserDao ud = new UserDao();
        if (password == null) return 3;
        if (accound == null) return 4;
        if (ud.getByAccount(accound) != 0) {
            if (Objects.equals(password, ud.getByPassword(accound))) {
                Global.user.setId(ud.getIdByAccount(accound));
                return 0;
            } else {
                return 2;
            }
        }
        return 1;
    }

    //返回0 注册成功
    //返回1 账号为空
    //返回2 密码为空
    //返回3 账号存在
    //返回4 密码不合法
    public int signUp(String account, String password) throws Exception {
        User user = new User();
        UserDao ud = new UserDao();
        if (account == null) return 1;
        if (password == null) return 2;
        if (ud.getByAccount(account) != 0) return 3;
        user.setAccount(account);
        user.setPassword(password);
        ud.insert(user);
        return 0;
    }
}

