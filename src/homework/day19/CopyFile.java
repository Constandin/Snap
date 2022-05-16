/**
 * 设计一个方法，带两个参数，第一个目录名，第二个文件名
 * 规则：
 * 1，在目录中是否已存在同名的文件，有的话不允许拷贝
 * 2，文件就在自己所在所在的目录中拷贝，则改名再拷贝
 */
package homework.day19;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyFile {


    public static boolean ableCopyFile(String pathname, File file) {
        boolean ableCopyFile = false;
        File file0 = new File(pathname);
        List<String> fileNames = new ArrayList<>(Arrays.asList(file0.list()));
        if (!fileNames.contains(file.getName())||file.getParent().equals(pathname)) {
            ableCopyFile = true;

        }
        return ableCopyFile;
    }

    public static void copyFile(String pathname, File file) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        String source = file.getAbsolutePath();
        int num = 1;
        int dotNum = file.getName().lastIndexOf(".");
        String fileName = null;
        String fileType = null;
        String contactName = fileName + "%S" + fileType;

            fileType = file.getName().substring(dotNum,file.getName().length());
            fileName = file.getName().substring(0, dotNum);
            contactName = String.format(fileName,num,fileType);


        try {
            input = Files.newInputStream(Paths.get(source));
            output = Files.newOutputStream(Paths.get(pathname + contactName));
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) > 0) {
                output.write(buffer, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String pathname = "E:\\Markdown";
        File file = new File("E:\\Markdown\\Mysql.md");
        if(CopyFile.ableCopyFile("E:\\Markdown",file)){
            CopyFile.copyFile("E:\\Markdown",file);
        }

    }

}
