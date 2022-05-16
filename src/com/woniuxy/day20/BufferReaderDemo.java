package com.woniuxy.day20;

import java.io.*;

public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\计算机\\Java\\cxuan PDF 大全\\新建 文本文档.txt"));
        BufferedWriter r = new BufferedWriter(new FileWriter("test.txt"));

        String s = null;
        while ((s = reader.readLine()) != null) {
            r.write(s,0,reader.readLine().length());
            System.out.println(s);

        }
        reader.close();
    }
}
