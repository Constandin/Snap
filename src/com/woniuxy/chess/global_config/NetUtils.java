package com.woniuxy.chess.global_config;

import com.woniuxy.chess.message.Message;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;



        public class NetUtils {
            public static void sendMessage(Message msg,String oppoIP) {
                try (Socket socket = new Socket(Global.oppoIp, Global.oppoPort)) {
                    OutputStream os = socket.getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    oos.writeObject(msg);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
