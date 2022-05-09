package com.woniuxy.day09;

public class DoubleColBall {
    public int[] codeLottery() {
        // 红、蓝球数量可更改；
        int[] arrLoterry = new int[7];
        int[] redBall = new int[6];
        int[] blueBall = new int[1];

        // 红球；
        for (int i = 0; i < redBall.length; i++) {
            redBall[i] = (int) (Math.random() * 33 + 1);
            for (int j = 0; j < i; j++) {
                if (redBall[j] == redBall[i]) {
                    i--;
                    break;
                }
            }
        }

        // 蓝球；
        for (int i = 0; i < blueBall.length; i++) {
            blueBall[i] = (int) (Math.random() * 16 + 1);
        }

        // 最终顺序；
        for (int i = 0; i < arrLoterry.length; i++) {
            if (i < redBall.length) {
                arrLoterry[i] = redBall[i];
            } else {
                arrLoterry[i] = blueBall[i - redBall.length];
            }
        }
        return arrLoterry;
    }

}
