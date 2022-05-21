package com.woniuxy.chess.ui;

import com.woniuxy.chess.global_config.Global;
import com.woniuxy.chess.service.UserService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.regex.Pattern;

// 登录；
public class SignInStage extends Stage {
    private Pane pane = new Pane();


    public SignInStage() {
        setResizable(false);
        setTitle("登录");
        setWidth(400);
        setHeight(400);
        Button confirm = new Button("确定");
        Button back = new Button("取消");
        Button register = new Button("注册");
        confirm.setPrefSize(50, 20);
        confirm.setLayoutX(50);
        confirm.setLayoutY(300);
        back.setPrefSize(50, 20);
        back.setLayoutX(175);
        back.setLayoutY(300);
        register.setPrefSize(50, 20);
        register.setLayoutX(300);
        register.setLayoutY(300);
        Label uname = new Label("用户名");
        Label passwrd = new Label("密码");
        uname.setLayoutX(100);
        uname.setLayoutY(100);
        passwrd.setLayoutX(100);
        passwrd.setLayoutY(200);
        TextArea user = new TextArea();
        PasswordField pword = new PasswordField();
        user.setPrefSize(200, 30);
        pword.setPrefSize(200, 30);
        user.setLayoutX(150);
        user.setLayoutY(100);
        pword.setLayoutX(150);
        pword.setLayoutY(200);

        pane.getChildren().addAll(confirm, back, register, uname, passwrd, user, pword);
        Scene scene = new Scene(pane);
        setScene(scene);
        show();

//        // 正则表达式规范账号密码
//        String patternAccount = "[\u4e00-\u9fa5_a-zA-Z0-9_]{1,15}";
//        String patternPassword = "[a-zA-Z0-9_]{6,15}";
//        boolean isPassword = Pattern.matches(patternPassword, password.getText());
//        boolean isAccount = Pattern.matches(patternAccount, account.getText());
//        if (!isAccount) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "账号需要为1-15位的中文，英文字母和数字及下划线");
//            alert.initOwner(this);
//            alert.show();
//            return;
//        }
//        if (!isPassword) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION, "密码需要为6-15位的英文字母和数字及下划线");
//            alert.initOwner(this);
//            alert.show();
//            return;
//        }

        register.setOnMouseClicked(e -> {
            SignUpStage su = new SignUpStage();
            su.show();
            this.close();
        });
        confirm.setOnMouseClicked(e -> {
            if (user.getText().trim().length() > 10 ||
                    user.getText().trim().length() < 3 ||
                    pword.getText().trim().length() > 10 ||
                    pword.getText().trim().length() < 3) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "账号或密码长度不合法");
                alert.show();
                return;
            }
            UserService us = new UserService();
            int regres;
            try {
                regres = us.signIn(user.getText(), pword.getText());
                Global.username = user.getText();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            if (regres == 0) {
                LANModelGameWindow lgw = new LANModelGameWindow();
                lgw.show();
                this.close();
            } else if (regres == 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "账号不存在");
                alert.show();
            } else if (regres == 2) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "密码错误");
                alert.show();
            } else if (regres == 3) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "密码为空");
                alert.show();
            } else if (regres == 4) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "账号为空");
                alert.show();
            }
        });
        back.setOnMouseClicked(event -> {
            ModelOption.m.show();
            this.close();
        });
    }
}
