package com.woniuxy.chess.entity;

public class Record {
    String result;
    String fightTme;
    private int id;
    private int black;
    private int white;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFightTme() {
        return fightTme;
    }

    public void setFightTme(String fightTme) {
        this.fightTme = fightTme;
    }
}
