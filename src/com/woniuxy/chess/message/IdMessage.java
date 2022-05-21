package com.woniuxy.chess.message;

public class IdMessage extends Message{
    private int id;
    public IdMessage(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}