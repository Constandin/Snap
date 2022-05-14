package com.woniuxy.chess;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MouseClick implements Config {
    int xIndex;
    int yIndex;
    private boolean isBlack = true;

    public boolean chessDrop(int x, int y){
        boolean isDrop = true;
        // 1，判断点击的位置是否在棋盘之外（是否在最外边之外）
        if(x < MARGIN || x > (MARGIN + LINE_GAP * (BOARD_SIZE -1)) || y < MARGIN || y > (MARGIN + LINE_GAP * (BOARD_SIZE - 1))){
            isDrop =  false;
        } else {


            int xTemp = (x-MARGIN) / LINE_GAP;
            int yTemp = (y-MARGIN) / LINE_GAP;

            int xNum = x - (LINE_GAP / 2) < (xTemp)*LINE_GAP + MARGIN ? (x-MARGIN) / LINE_GAP : (x-MARGIN) / LINE_GAP + 1;
            int yNum = y - (LINE_GAP / 2) < (yTemp)*LINE_GAP + MARGIN ? (y-MARGIN) / LINE_GAP : (y-MARGIN) / LINE_GAP + 1;
            // 将棋盘坐标转化为全局坐标；
            xIndex = xNum * LINE_GAP + MARGIN;
            yIndex = yNum * LINE_GAP + MARGIN;
        }
        return isDrop;



    }
}
