package com.woniuxy.chess.global_config;


import com.woniuxy.chess.LANModelGame;
import com.woniuxy.chess.message.Message;
import javafx.application.Platform;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 线程；
// 继承抽象类一定要实现抽象方法；
// 线程的声明，直接继承线程类是常见做法，重写run（）方法；
public class LANServerThread implements Runnable {
    private LANModelGame lanModelGame;
    public LANServerThread(LANModelGame lanModelGame) {
        this.lanModelGame = lanModelGame;
    }

    // 方法重写不能抛异常；
    // thread.sleep();
    // thread 一启动，系统自动分配时间线，主线程和该线程同时工作；
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(Global.myPort);
            System.out.println("启动服务器端，端口：" + Global.myPort);
            while (true) {
                Socket socket = server.accept();
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                // 获取客户端消息
                Message message = (Message) ois.readObject();
//                System.out.println(message);
                Platform.runLater(() -> {
                    lanModelGame.updateUI(message);
                    //任何更新界面组件信息的代码
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}