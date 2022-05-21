package com.woniuxy.chess;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Optional;
import static com.woniuxy.chess.NetUtils.sendMessage;

public class LANModelGame extends Stage {
    private Pane pane = new Pane();

    public LANModelGame() {
        int height = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;
        int width = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;

        // 创建舞台内容容器对象
        Scene scene = new Scene(pane, Global.GAME_WINDOW_WIDTH, Global.GAME_WINDOW_HEIGHT);
        setTitle("SnapChess");
        setHeight(height);// 设置高度；
        setWidth(width);// 设置宽度；
        setResizable(false);// 固定大小；

        // 将舞台内容容器对象关联到舞台对象中
        setScene(scene);

        // 创建布局容器对象(面板)
//        pane.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, null, null)));
        // 绘制棋盘
        Global.drawBoard(pane);
        // 设置按钮
        Global.setButton(pane);

        // 下棋；
        MouseClick mouse = new MouseClick();
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

        // 为面板添加鼠标点击事件
        pane.setOnMouseClicked(event -> {
//            Chess chess = new Chess();
            if (Global.START && Global.isMyTurn) {
                int x = (int) event.getX(); // 鼠标点击时的x坐标
                int y = (int) event.getY(); // 鼠标点击时的y坐标
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

                        // 落子后发送落子信息；
                        ChessMessage chessMessage = new ChessMessage();
                        chessMessage.setChess(chess);
                        sendMessage(chessMessage);
                        Global.isMyTurn = false;

                        //如果可以落子，界面添加棋子并落子；
                        if (mouse.dropAndWin(circle, chess)) {
                            Global.GAME_OVER = true;
                            Global.START = false;
                        }
                        pane.getChildren().add(circle);
                        for (Chess chess0 : Global.CHESS_ARRAY) {
                            System.out.println("坐标" + chess0.getxIndex() + "," + chess0.getyIndex() + "," + Global.CHESS_ARRAY.size());
                        }
                    }
                }
            }
        });

        //为关闭窗口注册事件
        setOnCloseRequest(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> buttonExit = alert.showAndWait();
            if (buttonExit.orElse(null) == ButtonType.OK) { // 点击的是确定按钮
                System.exit(0);
            }
        });
    }

    public void updateUI(Message message) {

        // 判断具体是哪种消息
        if (message instanceof ChessMessage) {

            ChessMessage chessMessage = (ChessMessage) message;

            Global.CHESS_ARRAY.add(chessMessage.getChess());

            Circle circle = new Circle(chessMessage.getChess().getxIndex(),
                    chessMessage.getChess().getyIndex(), Global.CHESS_SIZE);

            System.out.println("消息传递后" + Global.CHESS_ARRAY.size());

            if (Global.CHESS_ARRAY.size() % 2 == 0) {
                circle.setFill(Color.WHITE);
            } else {
                circle.setFill(Color.BLACK);
            }
            pane.getChildren().add(circle);
            Global.isMyTurn = true;
        }
    }


}