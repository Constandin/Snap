package com.woniuxy.day16;

import java.util.ArrayList;

public  class ArrayListDemo {
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public static  ArrayList<String> nameArray(Student student){
        students.add(student);
        if(student.getName().length()> 5 ){
            names.add(student.getName());
        }
        return names;
    }
    public static int numArray(int a){
        numbers.add(a);
       for(int i=0; i<numbers.size(); i++){
           for(int j=0,temp = 0; j<numbers.size() - 1; j++){
               if(numbers.get(i) < numbers.get(i + 1)){
                   temp = numbers.get(i+1);
                   numbers.set(i+1,numbers.get(i));
                   numbers.set(i,temp);
               }
           }

       }
        return numbers.get(numbers.size() - 1);
    }
}

class ArrayListTest{
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("123455");
        Student stu2 = new Student();
        stu2.setName("123456");
        Student stu3 = new Student();
        stu3.setName("12345678");
        ArrayListDemo.nameArray(stu1);
        ArrayListDemo.nameArray(stu2);
        ArrayList<String> nameslist = ArrayListDemo.nameArray(stu3);
        System.out.println(nameslist);


    }
}
