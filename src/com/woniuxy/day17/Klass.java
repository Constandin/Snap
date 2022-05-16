package com.woniuxy.day17;

import java.util.Iterator;

public class Klass implements Iterable {
private Student[] students = new Student[10];
private int size;

    public static void main(String[] args) {
        Klass klass = new Klass();
        Student stu1 = new Student("Tom",20);
        Student stu2 = new Student("Jack",20);
        Student stu3 = new Student("Rose",20);
        klass.add(stu1);
        klass.add(stu2);
        klass.add(stu3);
        for (Object stu : klass) {
            System.out.println(stu);
        }
    }
//    private class Iter implements Iterator<Student> {
//
//        @Override
//        public boolean hasNext() {
//            // TODO Auto-generated method stub
//            return false;
//        }
//
//        @Override
//        public Student next() {
//            // TODO Auto-generated method stub
//            return null;
//        }
//
//    }

public void add(Student student){
    students[size++] = student;
}

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>(){
            int position = 0;

            @Override
            public boolean hasNext() {
                return position != size;
            }

            @Override
            public Student next() {
                return students[position++];
            }
        };
    }
}
