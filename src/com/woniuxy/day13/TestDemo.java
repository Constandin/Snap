/**
 * 统计一个给定的字符串，统计其中字母，数字，其他字符的数量
 * 判断一个全路径文件名（D:\\90班\1.jpg）是否是合法的图片名
 * 已知一个18位身份证号码（字符串），求出其出生年月日(格式:1990年03月01号或1991年11月29号)
 */
package com.woniuxy.day13;

import com.woniuxy.day02.Calender;

import java.util.Calendar;

class Stats {
    public void stats(String s) {
        int othersNums = 0, numNums = 0, charNums = 0;
        for (int i = 0; i < s.length(); i++) {
            char result = s.charAt(i);
            if ((int) result >= 97 && (int) result <= 122 || (int) result >= 65 && (int) result <= 90) {
                charNums++;
            } else if ((int) result >= 48 && (int) result <= 57) {
                numNums++;
            } else {
                othersNums++;
            }
        }
        System.out.println("charNums=" + charNums + "numNums=" + numNums+ "othersNums=" + othersNums);
    }
}

class JudgeName{
    public boolean judgeName(String s){

        if(s!=null){
            return s.endsWith(".jpg");
        } else {
            return false;
        }

        }

}

