package com.woniuxy.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {


    public static void main(String[] args) {

//        List<Integer> nums= new ArrayList<>();
//
//        nums.add(1);
//
//        nums.add(2);
//
//        nums.add(3);
//
//        nums.add(4);
//
//        nums.add(5);
//
//        nums.stream().filter(e -> e % 2 == 0).map(e -> e * 2).forEach(System.out::println);

        Stream.of("Tom","Jack","Tommy","Tan","Rose").filter(e ->e.startsWith("T")).map( e->e.concat("!")).forEach(System.out::println);
    }
}
