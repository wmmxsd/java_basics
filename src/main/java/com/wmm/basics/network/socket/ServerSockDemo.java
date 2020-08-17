package com.wmm.basics.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockDemo {
    private final static String IP = "192.168.119.25";
    private final static int PORT = 51412;

    public void startServer () throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        try {
            byte[] bytes;
            // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
            while (true) {
                bytes = new byte[1024];
                // 然后读取指定长度的消息即可
                inputStream.read(bytes);
                System.out.println("get message from client: " + new String(bytes, "UTF-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            inputStream.close();
            socket.close();
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new ServerSockDemo().startServer();
    }
}
