/**
 * 随机产生1000个1-10之间的整数，统计其出现的次数
 */
package com.woniuxy.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo02 {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        for(int i =1 ; i<=1000;i++){
            int temp = (int)(Math.random()*10+1);
            result.add(temp);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:result){
            int i = 1; //定义一个计数器，用来记录重复数据的个数
            if(map.get(num) != null){
                i=map.get(num)+1;
            }
            map.put(num,i);
        }
        System.out.println("重复数据的个数："+ map);


        System.out.print("重复的数据为：");
        for(Integer  n:map.keySet()){
            if(map.get(n) > 1){
                System.out.print(n+" ");
            }
        }



        Map<String,String> maps = new HashMap<>();
        maps.put("abc","abc");
        maps.put("abd","abc");
        maps.put("abs","D");
        maps.put("123","12");
        maps.put("1b","董");
        for(String key:maps.keySet()){
            String value = maps.get(key);
            System.out.println(value);
        }


    }
}
