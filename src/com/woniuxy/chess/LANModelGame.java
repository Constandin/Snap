package com.woniuxy.chess;

import com.woniuxy.chess.dao.UserDao;
import com.woniuxy.chess.entity.Record;
import com.woniuxy.chess.entity.User;
import com.woniuxy.chess.global_config.Chess;
import com.woniuxy.chess.global_config.Global;
import com.woniuxy.chess.message.*;
import com.woniuxy.chess.global_config.NetUtils;
import com.woniuxy.chess.service.RecordService;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Optional;



public class LANModelGame extends Stage {
    private Pane pane = new Pane();
    private Circle myCircle = new Circle(15);
    private Circle nowCircle = new Circle(15);




    public LANModelGame() {
        int height = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;
        int width = Global.LINE_GAP * (Global.BOARD_SIZE - 1) + Global.BOARD_MARGIN * 2;

        // 创建舞台内容容器对象
        Scene scene = new Scene(pane, Global.GAME_WINDOW_WIDTH, Global.GAME_WINDOW_HEIGHT);
        setTitle("SnailChess");
        setHeight(height);// 设置高度；
        setWidth(width);// 设置宽度；
        setResizable(false);// 固定大小；

        // 将舞台内容容器对象关联到舞台对象中
        setScene(scene);

        // 创建布局容器对象(面板)
        pane.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));

        // 绘制棋盘
        Global.drawBoard(pane);
        // 设置按钮
        Global.setButton(pane);
        // 我的棋子图示定位


        Text userText = new Text(50, 100, "用户名:" + "  " + Global.username);
        userText.setFill(Color.BLACK);
        userText.setFont(Font.font("宋体",
                FontPosture.REGULAR, 20));
        pane.getChildren().add(userText);

        Text nowChess = new Text(50, 400, "当前落子");
        nowChess.setFill(Color.BLACK);
        nowChess.setFont(Font.font("宋体",
                FontPosture.REGULAR, 20));
        pane.getChildren().add(nowChess);

        Text myChess = new Text(50, 600, "您的棋子");
        myChess.setFill(Color.BLACK);
        myChess.setFont(Font.font("宋体",
                FontPosture.REGULAR, 20));
        pane.getChildren().add(myChess);


        // 开始/新局；
        Logic mouse = new Logic();

        Global.btnNew.setOnMouseClicked(e -> {
            NetUtils.sendMessage(new NewGameRequestMessage(), Global.oppoIp);

        });


        // 悔棋；
        Global.btnLastStep.setOnMouseClicked(e -> {
            if (!Global.isMyTurn && !Global.GAME_OVER && Global.CHESS_ARRAY.size() > 0) {
                NetUtils.sendMessage(new RequestUndoMessage(), Global.oppoIp);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("对战提醒");
                alert.setHeaderText("当前状态不可悔棋");
                alert.showAndWait();
            }
        });

        // 下棋；
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
                    if (Logic.addChess(chess)) {

                        //如果可以落子，界面添加棋子并落子；
                        if (mouse.dropAndWin(circle)) {
                            Global.GAME_OVER = true;
                            Global.START = false;
                            NetUtils.sendMessage(new WinMessage(), Global.oppoIp);
                        }



                        // 落子后发送落子信息；
                        ChessMessage chessMessage = new ChessMessage();
                        chessMessage.setChess(chess);
                        NetUtils.sendMessage(chessMessage, Global.oppoIp);
                        Global.isMyTurn = false;
                        pane.getChildren().add(circle);
                        for (Chess chess0 : Global.CHESS_ARRAY) {
                            System.out.println("坐标" + chess0.getxIndex() + "," + chess0.getyIndex() + "," + Global.CHESS_ARRAY.size());

                        }
                        // 落子后发送当前棋子信息；
                        nowChess();
                        NetUtils.sendMessage(new NowChessMessage(), Global.oppoIp);

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
        } else if (message instanceof NewGameRequestMessage) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("对战提醒");
            alert.setHeaderText("对方请求新局");
            alert.setContentText("确认以开始，取消以拒绝");
            Optional<ButtonType> buttonConfirm = alert.showAndWait();

            if (buttonConfirm.orElse(null) == ButtonType.OK) { // 点击的是确定按钮

                newGameEvent();
                myCircle.setFill(Color.WHITE);
                pane.getChildren().add(myCircle);

                NetUtils.sendMessage(new NewGameConfirmMessage(), Global.oppoIp);

            } else {
                NetUtils.sendMessage(new RejectMessage(), Global.oppoIp);
            }
        } else if (message instanceof NewGameConfirmMessage) {

            newGameEvent();
            myCircle.setFill(Color.BLACK);
            pane.getChildren().add(myCircle);

        } else if (message instanceof RejectMessage) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("对战提醒");
            alert.setHeaderText("对方已拒绝");
            alert.showAndWait();
        } else if (message instanceof WinMessage) {
            Global.GAME_OVER = false;
            Global.START = false;
            Alert winAlert = new Alert(Alert.AlertType.INFORMATION);

            winAlert.setTitle("提醒");
            winAlert.setHeaderText("对方已获胜");
            winAlert.showAndWait();
            NetUtils.sendMessage(new IdMessage(Global.user.getId()), Global.oppoIp);
        } else if (message instanceof RequestUndoMessage) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("对战提醒");
            alert.setHeaderText("对方请求悔棋");
            alert.setContentText("确认以允许，取消以拒绝");
            Optional<ButtonType> buttonConfirm = alert.showAndWait();
            if (buttonConfirm.orElse(null) == ButtonType.OK) { // 点击的是确定按钮
                pane.getChildren().remove(pane.getChildren().size() - 2);// 移除pane中类型为Circle的控件
                Global.CHESS_ARRAY.remove(Global.CHESS_ARRAY.size() - 1);
                nowChess();
                Global.isMyTurn = false;
                NetUtils.sendMessage(new UndoConfirmMessage(), Global.oppoIp);
            } else {
                NetUtils.sendMessage(new RejectMessage(), Global.oppoIp);
            }
        } else if (message instanceof UndoConfirmMessage) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("对战提醒");
            alert.setHeaderText("对方已同意悔棋");
            alert.setContentText("请继续");
            Global.isMyTurn = true;
            pane.getChildren().remove(pane.getChildren().size() - 2);// 移除pane中类型为Circle的控件
            Global.CHESS_ARRAY.remove(Global.CHESS_ARRAY.size() - 1);
            nowChess();
        } else if (message instanceof IdMessage) {
            User oppo;
            UserDao ud = new UserDao();
            try {
                oppo = ud.getById(((IdMessage) message).getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            User my;
            try {
                my = ud.getById(Global.user.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Record rd = new Record();
            //接受消息的一方如果是白方胜  则自己是黑方
            if (Global.CHESS_ARRAY.size() % 2 == 0) {
                rd.setWhite(my.getId());
                rd.setBlack(oppo.getId());
                rd.setResult("白胜");
            } else {
                rd.setWhite(oppo.getId());
                rd.setBlack(my.getId());
                rd.setResult("黑胜");
            }
            RecordService rs = new RecordService();
            rs.addRecord(rd);
        } else if (message instanceof NowChessMessage) {
            pane.getChildren().removeIf(c -> c == nowCircle);
            nowChess();
        }
    }

    public void newGameEvent() {
        Global.START = true;
        pane.getChildren().removeIf(c -> c instanceof Circle); // 移除pane中类型为Circle的控件

        Global.CHESS_ARRAY = new ArrayList<>();
        Global.GAME_OVER = false;
        myCircle.setLayoutX(85);
        myCircle.setLayoutY(650);

        drawFivePoint();
        Circle nowCircle = new Circle(15);
        nowCircle.setLayoutX(85);
        nowCircle.setLayoutY(450);

        nowCircle.setFill(Color.BLACK);
        pane.getChildren().add(nowCircle);
    }
    public void nowChess() {

        Circle nowCircle = new Circle(15);
        nowCircle.setLayoutX(85);
        nowCircle.setLayoutY(450);

        if (Global.CHESS_ARRAY.size() % 2 == 0) {
            nowCircle.setFill(Color.BLACK);
        } else {
            nowCircle.setFill(Color.WHITE);
        }
        pane.getChildren().add(nowCircle);

    }
    public void drawFivePoint(){
        // 绘制五点；
        Circle circle1 = new Circle(480, 480, 4);
        circle1.setFill(Color.BLACK);
        Circle circle2 = new Circle(320, 640, 4);
        circle2.setFill(Color.BLACK);
        Circle circle3 = new Circle(640, 320, 4);
        circle3.setFill(Color.BLACK);
        Circle circle4 = new Circle(320, 320, 4);
        circle4.setFill(Color.BLACK);
        Circle circle5 = new Circle(640, 640, 4);
        circle5.setFill(Color.BLACK);
        pane.getChildren().addAll(circle1, circle2, circle3, circle4, circle5);
    }
}
