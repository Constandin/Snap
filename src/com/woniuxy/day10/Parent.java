package com.woniuxy.day10;

public class Parent {
    public  int evenNumEqual (int[] arr){
        int i = 0,j = 0;
        for (; i < arr.length; i++){
            if((arr[i] % 2) == 0){
                j++ ;
            }
        }
        return j;
    }

}
