package com.wmm.basics.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/6/3 16:42
 */
public class UdpServer {
    public void receive(int port) throws IOException {
        System.out.println("UDP接收数据：begin");
        DatagramSocket datagramSocket = new DatagramSocket(514);
        // 创建字节数组，指定接收的数据包的大小
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        System.out.println("服务器端已经启动，等待客户端发送数据");
        // 此方法在接收到数据报之前会一直阻塞
        while (true) {
            datagramSocket.receive(packet);
            String info = new String(data, 0, packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("数据内容:" + info);
        }
    }

    public static void main(String[] args) {
        UdpServer udpServer = new UdpServer();
        try {
            udpServer.receive(514);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
