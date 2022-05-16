/**
 * 设计一个方法，带两个参数，第一个目录名，第二个文件名
 * 规则：
 * 1，在目录中是否已存在同名的文件，有的话不允许拷贝
 * 2，文件就在自己所在所在的目录中拷贝，则改名再拷贝
 */
package homework.day19;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;


public class CopyFile0 {
    public static void copyFile(String dir, String name) {
        File file = new File(name);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        byte[] b = new byte[1024];
        int i = -1;
        //file.getAbsolutePath();
        File f = new File((dir + name));
        String des = null;
        int num = 1;
        int dotNum = name.lastIndexOf(".");

        while (f.exists()) {
            String fileType = name.substring(dotNum ,f.getName().length());
            String fileName = name.substring(0, dotNum);


            String contactName = String.format(fileName, num, fileType);
            f = new File((dir + contactName));
            num++;
        }
        try (InputStream is = new FileInputStream(name);
             OutputStream os = new FileOutputStream((dir + f.getName()))) {
            while ((i = is.read(b, 0, b.length)) != -1) {
                os.write(b, 0, i);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public static void main (String[]args){
            String dir = "E:\\Markdown\\";
            String name = "ConstandinD.iml";
            CopyFile0.copyFile(dir, name);
        }
    }



