package com.woniuxy.chess.entity;

public class User {
    int id;
    private String account;
    private String password;
    private String regTime;
    private int winGame;
    private int loseGame;
    private int tieGame;
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getWinGame() {
        return winGame;
    }

    public void setWinGame(int winGame) {
        this.winGame = winGame;
    }

    public int getLoseGame() {
        return loseGame;
    }

    public void setLoseGame(int loseGame) {
        this.loseGame = loseGame;
    }

    public int getTieGame() {
        return tieGame;
    }

    public void setTieGame(int tieGame) {
        this.tieGame = tieGame;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

