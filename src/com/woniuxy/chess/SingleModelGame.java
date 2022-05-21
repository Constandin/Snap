package com.woniuxy.chess;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;//棋子；
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import static com.woniuxy.chess.Global.GAME_WINDOW_HEIGHT;
import static com.woniuxy.chess.Global.GAME_WINDOW_WIDTH;
public class SingleModelGame extends Stage {
    // 棋局结束；
//    private boolean start = false;
    private final int height = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;
    private final int width = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;

    public SingleModelGame() {

        // 设置窗体；

        setTitle("SnapChess");// 标题；
        setHeight(height);// 设置高度；
        setWidth(width);// 设置宽度；
        setResizable(false);// 固定大小；

        // 创建面板，场景；
        Pane pane = new Pane();//面板，展示各种控件的载体；
        Scene scene = new Scene(pane, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);//场景，存放面板；

        // 绘制棋盘；
        Global.drawBoard(pane);
        // 设置按钮；
        Global.setButton(pane);


//        // 设置按钮；
//        Button btnNew = new Button("开始/清局");
//        btnNew.setPrefSize(100, 50); // 按钮大小
//        btnNew.setLayoutX(80); // x的坐标
//        btnNew.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnNew);
//
//        Button btnLastStep = new Button("悔    棋");
//        btnLastStep.setPrefSize(100, 50); // 按钮大小
//        btnLastStep.setLayoutX(220); // x的坐标
//        btnLastStep.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnLastStep);
//
//        Button btnSave = new Button("保存 棋谱");
//        btnSave.setPrefSize(100, 50); // 按钮大小
//        btnSave.setLayoutX(360); // x的坐标
//        btnSave.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnSave);
//
//        Button btnRecall = new Button("复盘 打谱");
//        btnRecall.setPrefSize(100, 50); // 按钮大小
//        btnRecall.setLayoutX(500); // x的坐标
//        btnRecall.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnRecall);
//
//        Button btnOptionMode = new Button("切换 模式");
//        btnOptionMode.setPrefSize(100, 50); // 按钮大小
//        btnOptionMode.setLayoutX(640); // x的坐标
//        btnOptionMode.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnOptionMode);
//
//        Button btnQuit = new Button("退   出");
//        btnQuit.setPrefSize(100, 50); // 按钮大小
//        btnQuit.setLayoutX(780); // x的坐标
//        btnQuit.setLayoutY(800); // y的坐标
//        pane.getChildren().add(btnQuit);
//
//        // 复盘上一步、下一步按钮；
//
//        Button prevStep = new Button("prev");
//        prevStep.setPrefSize(50, 40);
//        prevStep.setLayoutX(800); // x的坐标
//        prevStep.setLayoutY(430); // y的坐标
//
//
//        Button nextStep = new Button("next");
//        nextStep.setPrefSize(50, 40);
//        nextStep.setLayoutX(800); // x的坐标
//        nextStep.setLayoutY(490); // y的坐标


        // 创建鼠标监听器；
        MouseClick mouse = new MouseClick();

        // 核心：落子及胜负;
        pane.setOnMouseClicked(e -> {
            if (Global.START) {
                int x = (int) e.getX(); // 鼠标点击时的x坐标
                int y = (int) e.getY(); // 鼠标点击时的y坐标
                // 落子；
                // 判断点击处是否在棋盘内；
                if (mouse.isChessDrop(x, y) && !Global.GAME_OVER) {
                    // 圆形，表示一颗棋子;
                    Circle circle = new Circle(Global.CHESS_SIZE);
                    circle.setLayoutX(mouse.xIndex0);
                    circle.setLayoutY(mouse.yIndex0);
                    // 设置棋子属性；
                    Chess chess = new Chess();
                    chess.setChess(mouse.xIndex0, mouse.yIndex0);
                    // 判断点击处能否落子；
                    if (MouseClick.addChess(chess)) {
                        //如果可以落子，界面添加棋子并落子；
                        if (mouse.dropAndWin(circle, chess)) {
                            Global.GAME_OVER = true;
                            Global.START = false;
                        }
                        pane.getChildren().add(circle);
                    }
                }
            }
        });

        // 清局；
        Global.btnNew.setOnMouseClicked(e -> {
            Global.START = true;
            // pane中的棋子全部删除
            // 存储chess的数组，清空
            // gameover恢复为false
            pane.getChildren().removeIf(c -> c instanceof Circle); // 移除pane中类型为Circle的控件
            pane.getChildren().removeIf(c -> c == Global.prevStep || c == Global.nextStep);
            Global.CHESS_ARRAY = new ArrayList<>();
            Global.GAME_OVER = false;
        });

        // 悔棋；
        Global.btnLastStep.setOnMouseClicked(e -> {
            if (!Global.GAME_OVER && Global.CHESS_ARRAY.size() > 0) {
                pane.getChildren().remove(pane.getChildren().size() - 1);// 移除pane中类型为Circle的控件
                Global.CHESS_ARRAY.remove(Global.CHESS_ARRAY.size() - 1);
            }
        });
        // 保存棋谱；
        Global.btnSave.setOnMouseClicked(e -> {
            if (Global.GAME_OVER) {
                FileChooser fileChooser = new FileChooser();

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Chess Files", "*.chess")

                );
                File file = fileChooser.showSaveDialog(this);


                try {
                    mouse.save(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        // 读取棋谱；
        Global.btnRecall.setOnMouseClicked(e -> {
            if (!Global.START || Global.GAME_OVER) {
                pane.getChildren().removeIf(c -> c instanceof Circle);
                FileChooser fileChooser = new FileChooser();

                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Chess Files", "*.chess")
                );
                File file = fileChooser.showOpenDialog(this);

                try {
                    mouse.read(file);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                pane.getChildren().add(Global.prevStep);
                pane.getChildren().add(Global.nextStep);

            }
        });
        // 复盘上一步；
        Global.prevStep.setOnMouseClicked(e -> {
            if (mouse.isPrev()) {

                pane.getChildren().remove(pane.getChildren().size() - 1);
            }
        });

        // 复盘下一步；
        Global.nextStep.setOnMouseClicked(e -> {
            Circle circle = new Circle(Global.CHESS_SIZE);
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
        Global.btnQuit.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> buttonExit = alert.showAndWait();
            if (buttonExit.orElse(null) == ButtonType.OK) { // 点击的是确定按钮
                System.exit(0);
            }
        });

        setScene(scene); // 设置场景到主舞

    }
}
