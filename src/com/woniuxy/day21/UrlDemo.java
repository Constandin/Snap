package com.woniuxy.day21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://xueqiu.com/?msclkid=72d1b05bcc3611ecaae08ac5f4a9607c");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        OutputStream os = new FileOutputStream("Html.html");
        byte[] bytes = new byte[1024];

        while((is.read(bytes)) != -1){
            os.write(bytes, 0, bytes.length);
        }


    }
}
