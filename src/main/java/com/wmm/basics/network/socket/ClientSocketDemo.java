package main.java.com.wmm.basics.network.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocketDemo {
    private final static String IP = "127.0.0.1";
    private final static int PORT = 5001;

    public void startClient() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(IP, PORT));
            OutputStream outputStream = socket.getOutputStream();
            String message = "你好  yiwangzhibujian";
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            //然后将消息再次发送出去
            outputStream.write(sendBytes);
            outputStream.flush();
            //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
            message = "第二条消息";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.flush();
            //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
            message = "the third message!";
            sendBytes = message.getBytes("UTF-8");
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            outputStream.write(sendBytes);
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientSocketDemo().startClient();
    }
}
