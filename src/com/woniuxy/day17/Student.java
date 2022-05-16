package com.woniuxy.day17;

public class Student implements Comparable<Student>{
    private int age;
    private String name;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student u = (Student) obj;
            return name.equals(u.name) && age == u.age;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name:" + name + ",Age:" + age;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
