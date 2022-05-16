/**
 * 方法：
 * public boolean exists():判断fle实例表示的文件或文件夹是否存在
 * public boolean createNewFile():创建新文件，一般先判断该文件是否存在
 * public boolean delete():删除文件
 * public String getParent(
 * public boolean isDirectory:判断是否是文件夹
 * public boolean isFile()判断是否是文件
 * public String[] list():获取文件夹中的文件或文件夹的名称字符串数组
 * public File listFiles()：获取文件夹中的文件或文件夹的File数组
 * public boolean mkdir():创建新文件夹
 * public boolean mkdirs():创建新文件夹
 * public boolean renameTo(File dest):重命名
 * 课堂练习：
 * 1,实现一个方法，接收Fil,在方法中判断参数File是否存在，存在则判断是否是文件，是，文件名存入数组，否则，把文件夹中的文件
 * 或文件夹的名称以数组形式返回（长度大于5）】
 */
package com.woniuxy.day19;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FileDemo {
    public static List<String> getFileNames(File file) {
        List<String> names = new ArrayList<>();
        if (file == null || !file.exists()) {
            throw new RuntimeException();
        }
        if (file.isFile()) {
            names.add(file.getName());
        } else {
            String[] fileNames = file.list((dir, name) -> name.length() > 5);
            names.addAll(Arrays.asList(fileNames));
//			for (String fileName : fileNames) {
//				if (fileName.length() > 5) {
//					names.add(fileName);
//				}
//			}
            Stream.of(fileNames).filter(name -> name.length() > 5).forEach(c -> names.add(c));
        }
        return names;

    }

    public static void main(String[] args) throws IOException {
        File file = new File("E:/90Java/javabase/src/com/woniuxy/day19_20220519/FileDemo.java");
        System.out.println(file.exists());

        file = new File("bin/com/woniuxy/day19_20220519/FileDemo.class");
        System.out.println(file.exists());

        File newFile = new File("demo2.txt");
        newFile.renameTo(new File("demo3.txt"));
//		if (!newFile.exists()) {
        newFile.createNewFile();
//		}
        System.out.println(newFile.getAbsolutePath());
        System.out.println(newFile.getParent());

        File direc1 = new File("E:/90Java/javabase/src/com/woniuxy");
        String[] names = direc1.list();
        for (String s : names) {
            System.out.println(s);
        }

    }

}