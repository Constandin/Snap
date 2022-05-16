package com.woniuxy.chess;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChessMethod implements Config, Serializable {
    static ArrayList<Chess> chesses = new ArrayList<>();

    // 添加对象；
    public static boolean addChess(Chess chess) {
        chesses.add(chess);
        int notRepeat = chesses.size();
        for (int i = 0; i < chesses.size(); i++) {
            for (int j = 0; j < i; j++) {
                Chess newChess = chesses.get(i);
                Chess preChess = chesses.get(j);
                if (newChess.getxIndex() == preChess.getxIndex() && newChess.getyIndex() == preChess.getyIndex()) {
                    chesses.remove(i);
                    break;
                }
            }
        }
        return notRepeat == chesses.size();
    }

    // 判断胜利；
    public static boolean win() {
        boolean isWin = false;
        //获取当前落子的坐标；
        int x = chesses.get(chesses.size() - 1).getxIndex();
        int y = chesses.get(chesses.size() - 1).getyIndex();

        ArrayList<Integer> xIndex = new ArrayList<>();// 水平方向与当前落子颜色相同，棋子横坐标集合；
        ArrayList<Integer> yIndex = new ArrayList<>();// 垂直方向与当前落子颜色相同，棋子纵坐标集合；
        ArrayList<Integer> obliqueUpIndex = new ArrayList<>();// 45°方向与落子颜色相同的横坐标集合；
        ArrayList<Integer> obliqueDownIndex = new ArrayList<>();// 135°方向与落子颜色相同的横坐标集合；

        // x方向；
        for (int i = chesses.size() % 2 != 0 ? 0 : 1; i < chesses.size(); i += 2) {
            if (chesses.get(i).getyIndex() == y) {
                xIndex.add(chesses.get(i).getxIndex());
            }
        }
        if (xIndex.size() == 5) {
            if (Collections.max(xIndex) - Collections.min(xIndex) == 4 * LINE_GAP) {
                isWin = true;
            }
        }

        // y方向；
        for (int i = chesses.size() % 2 != 0 ? 0 : 1; i < chesses.size(); i += 2) {
            if (chesses.get(i).getxIndex() == x) {
                yIndex.add(chesses.get(i).getyIndex());
            }
        }
        if (yIndex.size() == 5) {
            if (Collections.max(yIndex) - Collections.min(yIndex) == 4 * LINE_GAP) {
                isWin = true;
            }
        }

        // 斜线方向；

        // 落子处45°方向检索
        for (int i = chesses.size() % 2 != 0 ? 0 : 1; i < chesses.size(); i += 2) {
            if ((chesses.get(i).getxIndex() - x) == (chesses.get(i).getyIndex() - y)) {
                obliqueUpIndex.add(chesses.get(i).getxIndex());
            }
        }
        if (obliqueUpIndex.size() == 5) {
            if (Collections.max(obliqueUpIndex) - Collections.min(obliqueUpIndex) == 4 * LINE_GAP) {
                isWin = true;
            }
        }

        // 落子处135°方向检索
        for (int i = chesses.size() % 2 != 0 ? 0 : 1; i < chesses.size(); i += 2) {
            if ((chesses.get(i).getxIndex() - x) == -(chesses.get(i).getyIndex() - y)) {
                obliqueDownIndex.add(chesses.get(i).getxIndex());
            }
        }
        if (obliqueDownIndex.size() == 5) {
            if (Collections.max(obliqueDownIndex) - Collections.min(obliqueDownIndex) == 4 * LINE_GAP) {
                isWin = true;
            }
        }
        return isWin;
    }

//    // 保存棋谱；
//    public static void save(File file) throws IOException, FileNotFoundException {
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
//            oos.writeObject(chesses); // 数组序列化，对象也需要序列化；
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    // 读取棋谱；
//    public static void read(File file) throws Exception {
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            List<Chess> chessSave = (List<Chess>) ois.readObject();
//            for (Chess chess : chessSave) {
//                System.out.println(chess);
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//    }
//




}



