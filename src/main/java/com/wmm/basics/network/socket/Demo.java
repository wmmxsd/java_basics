package com.wmm.basics.network.socket;

public class Demo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ServerSockDemo().startServer();
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
