package com.woniuxy.chess.message;


import com.woniuxy.chess.global_config.Chess;

public class ChessMessage extends Message {
    private Chess chess;

    public Chess getChess() {
        return chess;
    }

    public void setChess(Chess chess) {
        this.chess = chess;
    }

}

