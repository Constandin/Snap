package com.woniuxy.day17;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User("Tom", 20));
        users.add(new User("Tom", 20));
        users.add(new User("Tom", 20));
        users.add(new User("Tom", 20));
        users.add(new User("Tom", 20));
        users.forEach(System.out::println);

        Set<Student> students = new TreeSet<>();
        students.add(new Student("Tom", 20));
        students.add(new Student("Jack", 25));
        students.add(new Student("Tom", 20));
        students.add(new Student("Rose", 23));
        students.add(new Student("Tommy", 22));

        System.out.println(students.size());
        System.out.println(students.contains(new Student("Tom", 20)));
        students.forEach(System.out::println);
    }
}