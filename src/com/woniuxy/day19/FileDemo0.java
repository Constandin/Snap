package com.woniuxy.day19;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileDemo0 {
    public static List<String> getFileNames(File file) {
        List<String> names = new ArrayList<>();
        if (file == null || !file.exists()) {
            throw new RuntimeException();
        }
        if (file.isFile()) {
            names.add(file.getName());
        } else {
//            String[] fileNames = file.list((dir,name)->name.length()>5);
//            names.addAll(Arrays.asList(fileNames));// Arrays.asList(),讲数组快速转成只读的List类型；
            // addAll 拷贝asLiof本进List里；
            Stream.of(file.list()).filter(name -> name.length() > 5).forEach(names::add);
//            Stream.of(file.list()).filter(name -> name.length() > 5).forEach(c -> names.add(c));
            // 流： 把filenames数组放进流里
        }
        return names;
    }


    public static void main(String[] args) throws IOException {
        // 创建对象，如果从计算机直接粘贴路径，\ 会变成 \\,原因 \ 易被识别乘转义字符；
//        File file = new File("F:\\IdeaCode\\ConstandinD\\src\\TestDemo.java");
        File file = new File("F:\\IdeaCode\\ConstandinD\\src");
        // 创建文件；
//        file.createNewFile();
//        file.renameTo(new File("TestDemo2.java"));

        System.out.println(file.exists()); // 判断文件是否存在；
        System.out.println(file.getAbsolutePath()); // 绝对路径；
        System.out.println(file.getParent()); // 父目录；
        System.out.println(FileDemo0.getFileNames(file));
    }
}
