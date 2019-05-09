package network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockDemo {
    private final static String IP = "127.0.0.1";
    private final static int PORT = 5001;

    public void startServer () {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes;
            // 因为可以复用Socket且能判断长度，所以可以一个Socket用到底
            while (true) {
                // 首先读取两个字节表示的长度
                int first = inputStream.read();
                //如果读取的值为-1 说明到了流的末尾，Socket已经被关闭了，此时将不能再去读取
                if(first==-1){
                    break;
                }
                int second = inputStream.read();
                int length = (first << 8) + second;
                // 然后构造一个指定长的byte数组
                bytes = new byte[length];
                // 然后读取指定长度的消息即可
                inputStream.read(bytes);
                System.out.println("get message from client: " + new String(bytes, "UTF-8"));
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerSockDemo().startServer();
    }
}
