package com.woniuxy.chess.ui;

import com.woniuxy.chess.service.UserService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

/**
 * 注册
 */
public class SignUpStage extends Stage {
    private Pane pane = new Pane();
    public SignUpStage(){
        setTitle("注册");
        setWidth(400);
        setHeight(400);
        setResizable(false);
        Button confirm = new Button("确定");
        Button back = new Button("取消");
        confirm.setPrefSize(50,20);
        confirm.setLayoutX(50);
        confirm.setLayoutY(300);
        back.setPrefSize(50,20);
        back.setLayoutX(200);
        back.setLayoutY(300);
        Label uname = new Label("用户名");
        Label passwrd = new Label("密码");
        Label repasswrd = new Label("确认密码");
//        Label confirm_passwrd = new Label("确认密码");
        uname.setLayoutX(100);
        uname.setLayoutY(100);
        repasswrd.setLayoutX(100);
        repasswrd.setLayoutY(150);
        passwrd.setLayoutX(100);
        passwrd.setLayoutY(200);
        TextArea user = new TextArea();
        PasswordField pword = new PasswordField();
        PasswordField repaswrd = new PasswordField();
        user.setPrefSize(200,30);
        pword.setPrefSize(200,30);
        user.setLayoutX(150);
        user.setLayoutY(100);
        pword.setLayoutX(150);
        pword.setLayoutY(200);
        repaswrd.setPrefSize(200,30);
        repaswrd.setLayoutX(150);
        repaswrd.setLayoutY(150);

        pane.getChildren().addAll(confirm,back,uname,passwrd,user,pword,repaswrd,repasswrd);
        Scene scene = new Scene(pane);
        setScene(scene);
        show();

        back.setOnMouseClicked(e->{
            SignInStage sis = new SignInStage();
            sis.show();
            this.close();
        });
        confirm.setOnMouseClicked(event -> {
            if (    user.getText().trim().length() > 10 ||
                    user.getText().trim().length() < 3 ||
                    pword.getText().trim().length() > 10 ||
                    pword.getText().trim().length() < 3 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING,"账号或密码长度不合法");
                alert.show();
                return;
            }
            if (!Objects.equals(repaswrd.getText(), pword.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING,"两次输入的密码不相同");
                alert.show();
                return;
            }
            UserService us = new UserService();
            int regres;
            try {
                regres=us.signUp(user.getText(),pword.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (regres==0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"注册成功,请登录");
                alert.show();
                SignInStage sis = new SignInStage();
                sis.show();
                this.close();
            }else if (regres==1){
                Alert alert = new Alert(Alert.AlertType.WARNING,"账号为空");
                alert.show();
            }else if (regres==2){
                Alert alert = new Alert(Alert.AlertType.WARNING,"密码为空");
                alert.show();
            }else if (regres==3){
                Alert alert = new Alert(Alert.AlertType.WARNING,"账号存在");
                alert.show();
            }else if (regres==4){
                Alert alert = new Alert(Alert.AlertType.WARNING,"密码不合法");
                alert.show();
            }
        });
    }
}
