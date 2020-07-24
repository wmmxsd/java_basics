package com.wmm.basics.network.socket;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ServerSockDemo().startServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ClientSocketDemo().startClient();
            }
        }).start();
    }
}
