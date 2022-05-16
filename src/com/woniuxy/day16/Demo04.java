package com.woniuxy.day16;
// 使用ArrayList存储若干学生的姓名，编写一个方法， 找出集合中姓名长度大于5的，将其从集合中删除
import java.util.ArrayList;

public class Demo04 {
    //方法1：
    public ArrayList<Student> deletaName1(ArrayList<Student> students){
        ArrayList<Student> result = new ArrayList<>();
        for(int i = 0; i <= students.size(); i++){
            if(students.get(i).getName().length() < 5){
                result.add(students.get(i));
            }
        }
        return result;
    }

    //方法2；
    public ArrayList<Student> deletaName2(ArrayList<Student> students){
        ArrayList<Student> result = new ArrayList<>();
        for(int i = 0; i <= students.size(); i++){
            if(students.get(i).getName().length() >= 5){
                result.remove(i--);
            }
        }
        return result;
    }
}

