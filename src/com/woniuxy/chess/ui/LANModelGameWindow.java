package com.woniuxy.chess.ui;

import com.woniuxy.chess.global_config.Global;
import com.woniuxy.chess.LANModelGame;
import com.woniuxy.chess.global_config.LANServerThread;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * 信息设置窗口
 *
 * @author 老谭 (<a href="http://www.woniuxy.com">蜗牛学苑</a>)
 */
public class LANModelGameWindow extends Stage implements EventHandler<MouseEvent> {
    private Button btnOK = new Button("确 定");
    private Button btnCancel = new Button("取 消");
    private TextField txtMyIp = new TextField("localhost");
    private TextField txtMyPort = new TextField("1111");
    private TextField txtOppoIp = new TextField("localhost");
    private TextField txtOppoPort = new TextField("2222");
    private Label lblMyIpMsg = new Label();
    private Label lblMyPortMsg = new Label();
    private Label lblOppoIpMsg = new Label();
    private Label lblOppoPortMsg = new Label();

    public LANModelGameWindow() {
        setTitle("局域网快速模式");
        setResizable(false);

        Pane pane = new Pane();
        Label lblMyIP = new Label("我的IP:");
        lblMyIP.setPrefSize(60, 20);
        lblMyIP.setLayoutX(30);
        lblMyIP.setLayoutY(30);

        txtMyIp.setPromptText("请输入我的IP");
        txtMyIp.setLayoutX(100);
        txtMyIp.setLayoutY(30);

        lblMyIpMsg.setPrefWidth(100);
        lblMyIpMsg.setLayoutX(250);
        lblMyIpMsg.setLayoutY(30);

        Label lblMyPort = new Label("我的端口:");
        lblMyPort.setPrefSize(60, 20);
        lblMyPort.setLayoutX(30);
        lblMyPort.setLayoutY(70);

        txtMyPort.setLayoutX(100);
        txtMyPort.setLayoutY(70);
        txtMyPort.setPromptText("请输入我的端口");

        lblMyPortMsg.setLayoutX(250);
        lblMyPortMsg.setLayoutY(70);

        Label lblOppoIp = new Label("对手IP:");
        lblOppoIp.setPrefSize(60, 20);
        lblOppoIp.setLayoutX(30);
        lblOppoIp.setLayoutY(110);

        txtOppoIp.setLayoutX(100);
        txtOppoIp.setLayoutY(110);
        txtOppoIp.setPromptText("请输入对手IP");

        lblOppoIpMsg.setLayoutX(250);
        lblOppoIpMsg.setLayoutY(110);

        Label lblOppoPort = new Label("对手端口:");
        lblOppoPort.setPrefSize(60, 20);
        lblOppoPort.setLayoutX(30);
        lblOppoPort.setLayoutY(150);

        txtOppoPort.setLayoutX(100);
        txtOppoPort.setLayoutY(150);
        txtOppoPort.setPromptText("请输入对手端口:");

        lblOppoPortMsg.setLayoutX(250);
        lblOppoPortMsg.setLayoutY(150);

        btnOK.setLayoutX(110);
        btnOK.setLayoutY(190);
        btnCancel.setLayoutX(180);
        btnCancel.setLayoutY(190);

        btnOK.setDefaultButton(true);
        btnCancel.setCancelButton(true);

        btnOK.setOnMouseClicked(this);
        btnCancel.setOnMouseClicked(this);

        pane.getChildren().addAll(lblMyIP, txtMyIp, lblMyIpMsg, lblMyPort, txtMyPort, lblMyPortMsg, lblOppoIp,
                txtOppoIp, lblOppoIpMsg, lblOppoPort, txtOppoPort, lblOppoPortMsg, btnOK, btnCancel);

        Scene scene = new Scene(pane, 400, 250);
        setScene(scene);

    }

    @Override
    public void handle(MouseEvent event) {
        // 获取事件的触发源
        Object source = event.getSource();
        System.out.println(source);
        if (source == btnOK) { // 点击的按钮是确定
            // 获取界面上4个单行文本框的值，存储到全局对象中
            Global.myIp = txtMyIp.getText();
            Global.myIp = txtMyIp.getText();
            Global.myPort = Integer.parseInt(txtMyPort.getText());
            Global.oppoIp = txtOppoIp.getText();
            Global.oppoPort = Integer.parseInt(txtOppoPort.getText());
            // 启动主棋盘（为了简化，复制一个之前的主棋盘）
            LANModelGame lanModelGame = new LANModelGame();
            lanModelGame.show();
            // 启动Server线程，用于接收客户端信息；
            // 线程需要start（）方法启动；
            new Thread(new LANServerThread(lanModelGame)).start();
            // 窗口关闭
            close();
        } else {
            // 窗口关闭
            hide();
        }
    }

}