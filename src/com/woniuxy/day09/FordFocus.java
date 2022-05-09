package com.woniuxy.day09;

public class FordFocus {
    private int speed;
    FordFocus(){
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void speedControl(String command,int variation) {

        if (command.equals("+")) {
            speed += variation;
            speed = speed < 185 ? Math.min(180, speed) : speed;

        } else if (command.equals("-")) {
            speed -= variation;
            speed = Math.max(0, speed);
        }
    }
}
