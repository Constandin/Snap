package com.woniuxy.chess;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class MouseClick implements Serializable{
    int xIndex0;
    int yIndex0;
    int count = -1;
    ArrayList<Chess> chessSave = null;



    // 能否添加棋子；(落子防重)
    public static boolean addChess(Chess chess) {
        Global.CHESS_ARRAY.add(chess);
        int notRepeat = Global.CHESS_ARRAY.size();
        for (int i = 0; i < Global.CHESS_ARRAY.size(); i++) {
            for (int j = 0; j < i; j++) {
                Chess newChess = Global.CHESS_ARRAY.get(i);
                Chess preChess = Global.CHESS_ARRAY.get(j);
                if (newChess.getxIndex() == preChess.getxIndex() && newChess.getyIndex() == preChess.getyIndex()) {
                    Global.CHESS_ARRAY.remove(i);
                    break;
                }
            }
        }
        return notRepeat == Global.CHESS_ARRAY.size();
    }

    // 判断胜利；
    public static boolean win() {
        boolean isWin = false;
        //获取当前落子的坐标；
        int x = Global.CHESS_ARRAY.get(Global.CHESS_ARRAY.size() - 1).getxIndex();
        int y = Global.CHESS_ARRAY.get(Global.CHESS_ARRAY.size() - 1).getyIndex();

        ArrayList<Integer> xIndex = new ArrayList<>();// 水平方向与当前落子颜色相同，棋子横坐标集合；
        ArrayList<Integer> yIndex = new ArrayList<>();// 垂直方向与当前落子颜色相同，棋子纵坐标集合；
        ArrayList<Integer> obliqueUpIndex = new ArrayList<>();// 45°方向与落子颜色相同的横坐标集合；
        ArrayList<Integer> obliqueDownIndex = new ArrayList<>();// 135°方向与落子颜色相同的横坐标集合；

        // x方向；
        for (int i = Global.CHESS_ARRAY.size() % 2 != 0 ? 0 : 1; i < Global.CHESS_ARRAY.size(); i += 2) {
            if (Global.CHESS_ARRAY.get(i).getyIndex() == y) {
                xIndex.add(Global.CHESS_ARRAY.get(i).getxIndex());
            }
        }
        if (xIndex.size() == 5) {
            if (Collections.max(xIndex) - Collections.min(xIndex) == 4 * Global.LINE_GAP) {
                isWin = true;
            }
        }

        // y方向；
        for (int i = Global.CHESS_ARRAY.size() % 2 != 0 ? 0 : 1; i < Global.CHESS_ARRAY.size(); i += 2) {
            if (Global.CHESS_ARRAY.get(i).getxIndex() == x) {
                yIndex.add(Global.CHESS_ARRAY.get(i).getyIndex());
            }
        }
        if (yIndex.size() == 5) {
            if (Collections.max(yIndex) - Collections.min(yIndex) == 4 * Global.LINE_GAP) {
                isWin = true;
            }
        }

        // 斜线方向；

        // 落子处45°方向检索
        for (int i = Global.CHESS_ARRAY.size() % 2 != 0 ? 0 : 1; i < Global.CHESS_ARRAY.size(); i += 2) {
            if ((Global.CHESS_ARRAY.get(i).getxIndex() - x) == (Global.CHESS_ARRAY.get(i).getyIndex() - y)) {
                obliqueUpIndex.add(Global.CHESS_ARRAY.get(i).getxIndex());
            }
        }
        if (obliqueUpIndex.size() == 5) {
            if (Collections.max(obliqueUpIndex) - Collections.min(obliqueUpIndex) == 4 * Global.LINE_GAP) {
                isWin = true;
            }
        }

        // 落子处135°方向检索
        for (int i = Global.CHESS_ARRAY.size() % 2 != 0 ? 0 : 1; i < Global.CHESS_ARRAY.size(); i += 2) {
            if ((Global.CHESS_ARRAY.get(i).getxIndex() - x) == -(Global.CHESS_ARRAY.get(i).getyIndex() - y)) {
                obliqueDownIndex.add(Global.CHESS_ARRAY.get(i).getxIndex());
            }
        }
        if (obliqueDownIndex.size() == 5) {
            if (Collections.max(obliqueDownIndex) - Collections.min(obliqueDownIndex) == 4 * Global.LINE_GAP) {
                isWin = true;
            }
        }
        return isWin;
    }

    // 鼠标点击处是否棋盘内；
    public boolean isChessDrop(int x, int y) {
        boolean isDrop = true;
        // 判断点击的位置是否在棋盘之外（是否在最外边之外）
        if (x < Global.BOARD_MARGIN || x > (Global.BOARD_MARGIN + Global.LINE_GAP * (Global.BOARD_SIZE - 1)) || y < Global.BOARD_MARGIN
                || y > (Global.BOARD_MARGIN + Global.LINE_GAP * (Global.BOARD_SIZE - 1))) {
            isDrop = false;
        } else {
            int xTemp = (x - Global.BOARD_MARGIN) / Global.LINE_GAP;
            int yTemp = (y - Global.BOARD_MARGIN) / Global.LINE_GAP;

            int xNum = x - (Global.LINE_GAP / 2) < (xTemp) * Global.LINE_GAP + Global.BOARD_MARGIN ?
                    (x - Global.BOARD_MARGIN) / Global.LINE_GAP : (x - Global.BOARD_MARGIN) / Global.LINE_GAP + 1;
            int yNum = y - (Global.LINE_GAP / 2) < (yTemp) * Global.LINE_GAP + Global.BOARD_MARGIN ?
                    (y - Global.BOARD_MARGIN) / Global.LINE_GAP : (y - Global.BOARD_MARGIN) / Global.LINE_GAP + 1;
            // 将棋盘坐标转化为全局坐标；
            xIndex0 = xNum * Global.LINE_GAP + Global.BOARD_MARGIN;
            yIndex0 = yNum * Global.LINE_GAP + Global.BOARD_MARGIN;
            System.out.println(xIndex0 + "  " + yIndex0);
        }
        return isDrop;

    }

    public boolean dropAndWin(Circle circle, Chess chess) {
        boolean isOver = false;

        // 添加棋子并判断胜负；

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("对战结果");
        if (Global.CHESS_ARRAY.size() % 2 == 0) {
            circle.setFill(Color.WHITE);
            if (MouseClick.win()) {
                alert.setHeaderText("优秀！");
                alert.setContentText("白棋胜");
                alert.show();
                isOver = true;
            }
        } else {
            circle.setFill(Color.BLACK);
            if (MouseClick.win()) {
                alert.setHeaderText("优秀！");
                alert.setContentText("黑棋胜");
                alert.show();
                isOver = true;
            } else if (!MouseClick.win()
                    && Global.CHESS_ARRAY.size() == Global.BOARD_SIZE * Global.BOARD_SIZE) {
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
            oos.writeObject(Global.CHESS_ARRAY); // 数组序列化，对象也需要序列化；
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 读取棋谱；
    public void read(File file) throws Exception {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            chessSave = (ArrayList<Chess>) ois.readObject();
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

//    public boolean lanDropAndWin(Circle circle, Chess chess) {
//        boolean isOver = false;
//
//        // LAN添加棋子并判断胜负；
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("对战结果");
//        System.out.println("落子时数元素个数" + Global.CHESS_ARRAY.size());
//        if (  Global.CHESS_ARRAY.size() % 2 == 0) {
//            circle.setFill(Color.WHITE);
//            if (MouseClick.win()) {
//                alert.setHeaderText("优秀！");
//                alert.setContentText("白棋胜");
//                alert.show();
//                isOver = true;
//            }
//        } else {
//            circle.setFill(Color.BLACK);
//            if (MouseClick.win()) {
//                alert.setHeaderText("优秀！");
//                alert.setContentText("黑棋胜");
//                alert.show();
//                isOver = true;
//            } else if (!MouseClick.win()
//                    && Global.CHESS_ARRAY.size() == Global.BOARD_SIZE * Global.BOARD_SIZE) {
//                System.out.println("和棋");
//                alert.setHeaderText("Sorry！");
//                alert.setContentText("和棋");
//                alert.show();
//                isOver = true;
//            }
//        }
//
//        return isOver;
//    }
//

}
