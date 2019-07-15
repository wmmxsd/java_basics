package main.java.com.wmm.basics.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

        Thread out = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pipedOutputStream.write("Hello World".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pipedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread in = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data;
                    while ((data = pipedInputStream.read()) != -1) {
                        System.out.print((char) data);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pipedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        out.start();
        in.start();
    }
}
