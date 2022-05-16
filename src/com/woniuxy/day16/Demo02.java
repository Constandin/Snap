/**
 * 产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台
 */
package com.woniuxy.day16;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public List<Double> random(){
        List<Double> result = new ArrayList<Double>();
        for(int i = 0; i <= 100;i++){
            double randomNum = Math.random() * 100 + 1;
            if(randomNum>=10){
            result.add(randomNum);
            }
        }
    return result;
    }
}
