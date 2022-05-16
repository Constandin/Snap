/**
 * 编写方法，计算两个List的交集，并集，差集
 */
package com.woniuxy.day16;


import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static List<Object> intersection(List<Object> arr1, List<Object> arr2) {
        List<Object> result = new ArrayList<>();

        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                if(arr1.get(i) == arr2.get(i)){
                    result.add(arr1.get(i));
                }
            }
        }
        return result;
    }
    public static List<Object> minus(List<Object> arr1, List<Object> arr2) {
        List<Object> result = new ArrayList<>();

        for (int i = 0; i < arr1.size(); i++) {
            boolean repeat = false;
            for (int j = 0; j < arr2.size(); j++){
                if(arr1.get(i) == arr2.get(i)) {
                    repeat = true;
                    break;
                }
            }
            if(!repeat){
                result.add(arr1.get(i));
            }
        }
        return result;
    }

    public static List<Object> union(List<Object> arr1, List<Object> arr2) {
        List<Object> result = new ArrayList<>();
        result.addAll(Demo01.minus(arr1,arr2));
        result.addAll(Demo01.minus(arr2,arr1));
        result.addAll(Demo01.intersection(arr1,arr2));
        return result;
    }
}
