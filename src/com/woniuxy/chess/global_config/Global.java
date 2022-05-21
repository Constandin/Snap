package com.woniuxy.chess.global_config;


import com.woniuxy.chess.entity.User;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;

import java.util.ArrayList;

// 棋盘GUI默认属性；
public class Global {
    // 全局界面
    // 线间距；
    public static final int LINE_GAP = 40;
    // 棋盘类型，如值15 即为15 x 15的棋盘；
    public static final int BOARD_SIZE = 15;
    // 棋盘线边缘；
    public static final int BOARD_MARGIN = 200;
    // 棋子尺寸；
    public static final int CHESS_SIZE = 20;
    public static final int GAME_WINDOW_WIDTH = 1000;
    public static final int GAME_WINDOW_HEIGHT = 1000;

    // 布尔标志类；
    public static boolean GAME_OVER = false;
    public static Boolean START = false;

    // 按钮类；
    public static Button btnNew = new Button("开始/清局");
    public static Button btnLastStep = new Button("悔    棋");
    public static Button btnSave = new Button("保存 棋谱");
    public static Button btnRecall = new Button("复盘 打谱");
    public static Button btnOptionMode = new Button("切换 模式");
    public static Button btnQuit = new Button("退   出");
    public static Button prevStep = new Button("prev");
    public static Button nextStep = new Button("next");

    // 网络和局域网类；
    public static String myIp;
    public static int myPort;
    public static String oppoIp;
    public static int oppoPort;

    public static boolean isMyTurn = true;
    // 用户账号
    public static User user = new User();
    public static String username;



    // 棋子序列；
    public static ArrayList<Chess> CHESS_ARRAY = new ArrayList<>();

    public static void drawBoard(Pane pane) {
        // 绘制棋盘；
        // 绘制x方向；
        for (int x0 = Global.BOARD_MARGIN, y0 = Global.BOARD_MARGIN, i = 1; i <= Global.BOARD_SIZE; i++) {
            Line line = new Line(x0, y0, x0 + 14 * Global.LINE_GAP, y0);
            pane.getChildren().add(line); // 将控件增加到面板中；
            y0 += Global.LINE_GAP;
        }
        // 绘制y方向；
        for (int x0 = Global.BOARD_MARGIN, y0 = Global.BOARD_MARGIN, i = 1; i <= Global.BOARD_SIZE; i++) {
            Line line = new Line(x0, y0, x0, y0 + 14 * Global.LINE_GAP);
            pane.getChildren().add(line); // 将控件增加到面板中；
            x0 += Global.LINE_GAP;
        }


    }

    public static void setButton(Pane pane){

        btnNew.setPrefSize(100, 50); // 按钮大小
        btnNew.setLayoutX(80); // x的坐标
        btnNew.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnNew);


        btnLastStep.setPrefSize(100, 50); // 按钮大小
        btnLastStep.setLayoutX(220); // x的坐标
        btnLastStep.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnLastStep);


        btnSave.setPrefSize(100, 50); // 按钮大小
        btnSave.setLayoutX(360); // x的坐标
        btnSave.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnSave);


        btnRecall.setPrefSize(100, 50); // 按钮大小
        btnRecall.setLayoutX(500); // x的坐标
        btnRecall.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnRecall);


        btnOptionMode.setPrefSize(100, 50); // 按钮大小
        btnOptionMode.setLayoutX(640); // x的坐标
        btnOptionMode.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnOptionMode);


        btnQuit.setPrefSize(100, 50); // 按钮大小
        btnQuit.setLayoutX(780); // x的坐标
        btnQuit.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnQuit);



        // 复盘上一步、下一步按钮；


        prevStep.setPrefSize(50, 40);
        prevStep.setLayoutX(800); // x的坐标
        prevStep.setLayoutY(430); // y的坐标



        nextStep.setPrefSize(50, 40);
        nextStep.setLayoutX(800); // x的坐标
        nextStep.setLayoutY(490); // y的坐标

    }

}
