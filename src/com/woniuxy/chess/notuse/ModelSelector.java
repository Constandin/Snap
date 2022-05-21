//package com.woniuxy.chess;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
///**
// * 游戏模式选择窗口，应用的入口
// *
//
// */
//public class ModelSelector extends Application {
//    public static void main(String[] args) {
//        launch();
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("游戏模式选择");
//        Pane pane = new Pane();
//        // TODO 增加按钮
//        Button newBtn = new Button("新局");
//        newBtn.setLayoutX(40);
//        newBtn.setLayoutY(40);
//
//        newBtn.setOnMouseClicked(t -> {
//
//            LoginStage loginStage=new LoginStage();
//            loginStage.show();
//        });
//
//        pane.getChildren().add(newBtn);
//        Scene scene = new Scene(pane, 600, 400);
//        primaryStage.setScene(scene);
//        // 设置窗体大小不可调整
//        primaryStage.setResizable(false);
//        // 显示窗体
//        primaryStage.show();
//    }
//}
