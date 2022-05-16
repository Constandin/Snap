package com.woniuxy.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;//棋子；
import javafx.scene.shape.Line;//连线绘制棋盘；
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class GameUI extends Application implements Config {
    // 棋局结束；
    boolean gameOver = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 设置窗体；
        int height = LINE_GAP * (BOARD_SIZE - 1) + MARGIN * 2;
        int width = LINE_GAP * (BOARD_SIZE - 1) + MARGIN * 2;
        primaryStage.setTitle("SnapChess");// 标题；
        primaryStage.setHeight(height);// 设置高度；
        primaryStage.setWidth(width);// 设置宽度；
        primaryStage.setResizable(false);// 固定大小；

        // 创建面板，场景；
        Pane pane = new Pane();//面板，展示各种控件的载体；
        Scene scene = new Scene(pane, 1000, 1000);//场景，存放面板；

        // 绘制棋盘；
        // 绘制x方向；
        for (int x0 = MARGIN, y0 = MARGIN, i = 1; i <= BOARD_SIZE; i++) {
            Line line = new Line(x0, y0, x0 + 14 * LINE_GAP, y0);
            pane.getChildren().add(line); // 将控件增加到面板中；
            y0 += LINE_GAP;
        }
        // 绘制y方向；
        for (int x0 = MARGIN, y0 = MARGIN, i = 1; i <= BOARD_SIZE; i++) {
            Line line = new Line(x0, y0, x0, y0 + 14 * LINE_GAP);
            pane.getChildren().add(line); // 将控件增加到面板中；
            x0 += LINE_GAP;
        }

        // 创建按钮；
        Button button = new Button();
        pane.getChildren().add(button);

        // 设置按钮；

        Button btnNew = new Button("开始/清局");
        btnNew.setPrefSize(90, 50); // 按钮大小
        btnNew.setLayoutX(105); // x的坐标
        btnNew.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnNew);

        Button btnLastStep = new Button("悔    棋");
        btnLastStep.setPrefSize(90, 50); // 按钮大小
        btnLastStep.setLayoutX(245); // x的坐标
        btnLastStep.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnLastStep);

        Button btnSave = new Button("保存 棋谱");
        btnSave.setPrefSize(90, 50); // 按钮大小
        btnSave.setLayoutX(385); // x的坐标
        btnSave.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnSave);

        Button btnRecall = new Button("复盘 打谱");
        btnRecall.setPrefSize(90, 50); // 按钮大小
        btnRecall.setLayoutX(525); // x的坐标
        btnRecall.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnRecall);

        Button btnOptionMode = new Button("切换 模式");
        btnOptionMode.setPrefSize(90, 50); // 按钮大小
        btnOptionMode.setLayoutX(665); // x的坐标
        btnOptionMode.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnOptionMode);

        Button btnQuit = new Button("退   出");
        btnQuit.setPrefSize(90, 50); // 按钮大小
        btnQuit.setLayoutX(805); // x的坐标
        btnQuit.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnQuit);

        // 创建鼠标监听器；
        MouseClick mouse = new MouseClick();

        // 核心：落子及胜负;
        pane.setOnMouseClicked(e -> {
            int x = (int) e.getX(); // 鼠标点击时的x坐标
            int y = (int) e.getY(); // 鼠标点击时的y坐标
            // 落子；
            if (mouse.isChessDrop(x, y) && !gameOver) {
                // 圆形，表示一颗棋子;
                Circle circle = new Circle(CHESS_SIZE);
                circle.setLayoutX(mouse.xIndex0);
                circle.setLayoutY(mouse.yIndex0);
                // 设置棋子属性；
                Chess chess = new Chess();
                chess.setChess(mouse.xIndex0, mouse.yIndex0);
                if (ChessMethod.addChess(chess)) {
                    if (mouse.dropAndWin(circle, chess)) {
                        gameOver = true;

                    }
                    pane.getChildren().add(circle);
                }
            }
        });

        // 清局；
        btnNew.setOnMouseClicked(e -> {
            // pane中的棋子全部删除
            // 存储chess的数组，清空
            // gameover恢复为false
            pane.getChildren().removeIf(c -> c instanceof Circle); // 移除pane中类型为Circle的控件
            ChessMethod.chesses = new ArrayList<>();
            gameOver = false;
        });

        // 悔棋；
        btnLastStep.setOnMouseClicked(e -> {
            if (!gameOver && ChessMethod.chesses.size() > 0) {
                pane.getChildren().remove(pane.getChildren().size() - 1);// 移除pane中类型为Circle的控件
                ChessMethod.chesses.remove(ChessMethod.chesses.size() - 1);
            }
        });

        // 退出；
        btnQuit.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> buttonExit = alert.showAndWait();
            if (buttonExit.orElse(null) == ButtonType.OK) { // 点击的是确定按钮
                System.exit(0);
            }
        });
        primaryStage.setScene(scene); // 设置场景到主舞台
        primaryStage.show(); // 展示舞台

    }
}
