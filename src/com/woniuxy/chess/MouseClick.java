package com.woniuxy.chess;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MouseClick implements Config {
    int xIndex0;
    int yIndex0;


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
        }
        return isDrop;

    }

    public boolean dropAndWin(int xIndex, int yIndex, Circle circle, Chess chess) {
        boolean isOver = false;

        // 添加棋子并判断胜负；
        if (ChessMethod.addChess(chess)) {
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
        }
        return isOver;
    }
}
