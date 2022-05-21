package com.woniuxy.chess;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.io.*;
import java.util.ArrayList;


public class MouseClick implements Config {
    int xIndex0;
    int yIndex0;
    int count = -1;
    ArrayList<Chess> chessSave = null;


    public boolean isChessDrop(int x, int y) {
        boolean isDrop = true;
        // 1，判断点击的位置是否在棋盘之外（是否在最外边之外）
        if (x < MARGIN || x > (MARGIN + LINE_GAP * (BOARD_SIZE - 1)) || y < MARGIN
                || y > (MARGIN + LINE_GAP * (BOARD_SIZE - 1))) {
            isDrop = false;
        } else {
            int xTemp = (x - MARGIN) / LINE_GAP;
            int yTemp = (y - MARGIN) / LINE_GAP;

            int xNum = x - (LINE_GAP / 2) < (xTemp) * LINE_GAP + MARGIN ?
                    (x - MARGIN) / LINE_GAP : (x - MARGIN) / LINE_GAP + 1;
            int yNum = y - (LINE_GAP / 2) < (yTemp) * LINE_GAP + MARGIN ?
                    (y - MARGIN) / LINE_GAP : (y - MARGIN) / LINE_GAP + 1;
            // 将棋盘坐标转化为全局坐标；
            xIndex0 = xNum * LINE_GAP + MARGIN;
            yIndex0 = yNum * LINE_GAP + MARGIN;
            System.out.println(xIndex0 + "  " + yIndex0);
        }
        return isDrop;

    }

    public boolean dropAndWin(Circle circle, Chess chess) {
        boolean isOver = false;

        // 添加棋子并判断胜负；

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("对战结果");
        if (ChessMethod.chesses.size() % 2 == 0) {
            circle.setFill(Color.WHITE);
            if (ChessMethod.win()) {
                alert.setHeaderText("优秀！");
                alert.setContentText("白棋胜");
                alert.show();
                isOver = true;
            }
        } else {
            circle.setFill(Color.BLACK);
            if (ChessMethod.win()) {
                alert.setHeaderText("优秀！");
                alert.setContentText("黑棋胜");
                alert.show();
                isOver = true;
            } else if (!ChessMethod.win()
                    && ChessMethod.chesses.size() == BOARD_SIZE * BOARD_SIZE) {
                System.out.println("和棋");
                alert.setHeaderText("Sorry！");
                alert.setContentText("和棋");
                alert.show();
                isOver = true;
            }
        }

        return isOver;
    }

    // 保存棋谱；
    public void save(File file) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ChessMethod.chesses); // 数组序列化，对象也需要序列化；
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 读取棋谱；
    public void read(File file) throws Exception {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            chessSave = (ArrayList<Chess>) ois.readObject();
//            for (Chess chess : chessSave) {
//                System.out.println(chess);
//            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    // 复盘下一步；
    public boolean isNext(Circle circle) {
        boolean isDropped = false;
        count++;
        if (count != chessSave.size() ) {
            circle.setFill(count % 2 == 0 ? Color.BLACK : Color.WHITE);
            isDropped = true;
        } else {
            count = chessSave.size() - 1;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setHeaderText("没有下一步了");
            alert.setContentText("请点击 开始/清局 以退出");
            alert.show();
        }
        return isDropped;
    }
    // 复盘上一步；
    public boolean isPrev() {
        boolean isRemoved = true;
        count--;
        if(count<-1){
            count = -1;
            isRemoved = false;
        }
        return isRemoved;
    }


}
