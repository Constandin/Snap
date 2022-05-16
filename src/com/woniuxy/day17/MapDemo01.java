/**
 * Map<Integer,String>map new HashMap<Integer,String>();
 * map.put(1,"张三")；
 * map.put(2,"李四")；
 * map.put(3,"王麻子")；
 * map.put(4,"老谭")；
 * 要求：
 * 1.遍历集合，并将序号与对应人名打印。
 * 2.向该map集合中插入一个编码为5姓名为"蜗牛学苑"的信息
 * 3.移除该map中的编号为4的信息
 * 4.将map集合中编号为3的姓名信息修改为"王五"
 */
package com.woniuxy.day17;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapDemo01 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王麻子");
        map.put(4, "老谭");
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.remove(4);
        map.put(3, "王五");
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

}
