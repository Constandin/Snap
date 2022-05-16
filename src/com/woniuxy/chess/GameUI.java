package com.woniuxy.chess;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Circle;//棋子；
import javafx.scene.shape.Line;//连线绘制棋盘；

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;

public class GameUI extends Application implements Config {
    // 棋局结束；
    boolean gameOver = false;
    boolean start = false;


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
        btnNew.setPrefSize(100, 50); // 按钮大小
        btnNew.setLayoutX(80); // x的坐标
        btnNew.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnNew);

        Button btnLastStep = new Button("悔    棋");
        btnLastStep.setPrefSize(100, 50); // 按钮大小
        btnLastStep.setLayoutX(220); // x的坐标
        btnLastStep.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnLastStep);

        Button btnSave = new Button("保存 棋谱");
        btnSave.setPrefSize(100, 50); // 按钮大小
        btnSave.setLayoutX(360); // x的坐标
        btnSave.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnSave);

        Button btnRecall = new Button("复盘 打谱");
        btnRecall.setPrefSize(100, 50); // 按钮大小
        btnRecall.setLayoutX(500); // x的坐标
        btnRecall.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnRecall);

        Button btnOptionMode = new Button("切换 模式");
        btnOptionMode.setPrefSize(100, 50); // 按钮大小
        btnOptionMode.setLayoutX(640); // x的坐标
        btnOptionMode.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnOptionMode);

        Button btnQuit = new Button("退   出");
        btnQuit.setPrefSize(100, 50); // 按钮大小
        btnQuit.setLayoutX(780); // x的坐标
        btnQuit.setLayoutY(800); // y的坐标
        pane.getChildren().add(btnQuit);

        // 复盘上一步、下一步按钮；

        Button prevStep = new Button("prev");
        prevStep.setPrefSize(50, 40);
        prevStep.setLayoutX(800); // x的坐标
        prevStep.setLayoutY(430); // y的坐标


        Button nextStep = new Button("next");
        nextStep.setPrefSize(50, 40);
        nextStep.setLayoutX(800); // x的坐标
        nextStep.setLayoutY(490); // y的坐标


        // 创建鼠标监听器；
        MouseClick mouse = new MouseClick();

        // 核心：落子及胜负;
        pane.setOnMouseClicked(e -> {
            if (start) {
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
                            start = false;
                        }
                        pane.getChildren().add(circle);
                    }
                }
            }
        });

        // 清局；
        btnNew.setOnMouseClicked(e -> {
            start = true;
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
        // 保存棋谱；
        btnSave.setOnMouseClicked(e -> {
            if (gameOver) {
                FileChooser fileChooser = new FileChooser();

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Chess Files", "*.chess")

                );
                File file = fileChooser.showSaveDialog(primaryStage);


                try {
                    mouse.save(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        // 读取棋谱；
        btnRecall.setOnMouseClicked(e -> {
            if (!start || gameOver) {
                pane.getChildren().removeIf(c -> c instanceof Circle);
                FileChooser fileChooser = new FileChooser();

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Chess Files", "*.chess")
                );
                File file = fileChooser.showOpenDialog(primaryStage);

                try {
                    mouse.read(file);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                pane.getChildren().add(prevStep);
                pane.getChildren().add(nextStep);

            }
        });
        // 复盘上一步；
        prevStep.setOnMouseClicked(e -> {
            if (mouse.isPrev()) {

                pane.getChildren().remove(pane.getChildren().size() - 1);
            }
        });

        // 复盘下一步；
        nextStep.setOnMouseClicked(e -> {
            Circle circle = new Circle(CHESS_SIZE);
            if (mouse.isNext(circle)) {

                for (Chess chess : mouse.chessSave) {
                    System.out.println(chess);
                }
                System.out.println(mouse.count);
                circle.setLayoutX(mouse.chessSave.get(mouse.count).getxIndex());


                circle.setLayoutY(mouse.chessSave.get(mouse.count).getyIndex());
                pane.getChildren().add(circle);
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
