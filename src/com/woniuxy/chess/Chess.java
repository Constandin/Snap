package com.woniuxy.chess;

import java.io.Serializable;

public class Chess extends Message implements Serializable {
    private int xIndex; // x坐标
    private int yIndex;// y坐标


    public void setChess(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int getxIndex() {
        return xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

}