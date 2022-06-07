//package com.woniuxy.chess;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.PasswordField;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//
//import javafx.scene.control.Button;
//
//import javafx.scene.control.Label;
//
//import javafx.scene.control.TextField;
//
///**
// * 登录窗口
// *
// * @author 蜗牛学院 (<a href="http://www.woniuxy.com">蜗牛学院</a>)
// */
//public class LoginStage extends Stage implements EventHandler<ActionEvent> {
//    private Button btnLogin = new Button("登录");
//    private Button btnCancel = new Button("取消");
//    private TextField txtAccount = new TextField();
//    private PasswordField txtPassword = new PasswordField();
//    private Hyperlink linkReg = new Hyperlink("免费注册");
//
//    public LoginStage() {
//        setTitle("用户登录-蜗牛学院");
//        setResizable(false);
//
//        Pane root = new Pane();
//
//        Label lblAccount = new Label("账      号:");
//        lblAccount.setPrefSize(60, 20);
//        lblAccount.setLayoutX(30);
//        lblAccount.setLayoutY(30);
//
//        txtAccount.setLayoutX(100);
//        txtAccount.setLayoutY(30);
//
//        Label lblPwd = new Label("密      码:");
//        lblPwd.setPrefSize(60, 20);
//        lblPwd.setLayoutX(30);
//        lblPwd.setLayoutY(70);
//
//        txtPassword.setLayoutX(100);
//        txtPassword.setLayoutY(70);
//
//        btnLogin.setLayoutX(60);
//        btnLogin.setLayoutY(110);
//        btnLogin.setDefaultButton(true);
//
//        btnCancel.setLayoutX(120);
//        btnCancel.setLayoutY(110);
//        btnCancel.setCancelButton(true);
//
//        linkReg.setLayoutX(180);
//        linkReg.setLayoutY(110);
//
//        btnLogin.setOnAction(this);
//        btnCancel.setOnAction(this);
//        linkReg.setOnAction(this);
//
//        root.getChildren().addAll(lblAccount, txtAccount, lblPwd, txtPassword, btnLogin, btnCancel, linkReg);
//
//        Scene scene = new Scene(root, 300, 150);
//        setScene(scene);
//
//    }
//
//    @Override
//    public void handle(ActionEvent event) {
//        Object source = event.getSource();
//        if (source == btnLogin) {
//            String account = "";
//            String password = "";
//
//            UserService userService = new UserService();
//            User user = userService.login(account, password);
//
//            // 如何判断到底登录成功还是没成功
//        } else if (source == linkReg) {
//            close();
//            new RegisterStage().show();
//        } else {
//            System.exit(0);
//        }
//    }
//
//}