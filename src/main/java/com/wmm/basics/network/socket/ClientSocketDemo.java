package com.wmm.basics.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ClientSocketDemo {
    private final static String IP = "192.168.119.213";
    private final static int PORT = 514;

    public void startClient() {
        try {
            System.out.println("发送 - begin");
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(IP, PORT));
            OutputStream outputStream = socket.getOutputStream();
            int index =0;
//            while (index < 10) {
                System.out.println("正在发送第" + index + "条消息");
                String message = "{\"minCode\":\"111111\",\"auditTableName\":\"cems_log_device_portcheckchangedlog\",\"logInfo\":[{\"id\":\"b2aca9c757ff468a88ed572743801eb8\",\"devonlyid\":\"3cb228c57c2b32d6d9873bc4c2c28102\",\"ip\":\"68.62.232.1\"},{\"id\":\"b2aca9c757ff468a88ed572743801eb8\",\"devonlyid\":\"3cb228c57c2b32d6d9873bc4c2c28102\",\"ip\":\"68.62.232.2\"}]}\n";
                //首先需要计算得知消息的长度
                byte[] sendBytes = message.getBytes(StandardCharsets.UTF_8);
                outputStream.write(sendBytes);
                Thread.sleep(1000);
                outputStream.flush();
                index++;
//            }

            Thread.sleep(2000);
            outputStream.close();
            socket.close();
            System.out.println("发送 - end");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientSocketDemo().startClient();
    }
}
