/**
 * 定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
 * 例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”
 */
package com.woniuxy.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo03 {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("abc");
        test.add("123");
        test.add("abcd");
        test.add("bbb");
        test.add("ccc");
        test.add("dd");
        test.add("aa");
        test.add("a");
        MapDemo03 map = new MapDemo03();
        map.charNum(test);

    }

    public void charNum(List<String> s) {
        List<Character> allChar = new ArrayList<>();

//        for (int i = 0; i < s.size(); i++) {
//            if (s.get(i) != null ) {
//                char[] arrChar = s.get(i).toCharArray();
//                for (Character c : arrChar) {
//                    allChar.add(c);
//                }
//            }
//        }

//        for (String value : s) {
//            if (value != null) {
//                char[] arrChar = value.toCharArray();
//                for (Character c : arrChar) {
//                    allChar.add(c);
//                }
//            }
//        }

//        for (int i = 0; i < s.size(); i++) {
//            if (s.get(i) != null) {
//                for(int j = 0;j<s.get(i).length();j++){
//                    allChar.add(s.get(i).charAt(j));
//                }
//            }
//        }
//
        for (String value : s) {
            if (value != null) {
                for (int j = 0; j < value.length(); j++) {
                    allChar.add(value.charAt(j));
                }
            }
        }




        Map<Character, Integer> repeat = new HashMap<>();
        for (Character c : allChar) {
            int i = 1;
            if (repeat.get(c) != null) {
                i = repeat.get(c) + 1;
            }
            repeat.put(c, i);
        }
        System.out.println("重复字母的各自个数为" + repeat);

    }
}
