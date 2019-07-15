package main.java.com.wmm.basics.network.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class nioDemo1 {
    public static void main(String[] args) {
        FileChannel channel = null;
        try {
            File file = new File("test.txt");
            if (file.exists()) {
                file.delete();
            }
            channel = new RandomAccessFile("test.txt", "rw").getChannel();
            channel.position(channel.size());  // 移动文件指针到末尾（追加写入）

            //分配一个新的ByteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
            System.out.println("allocate后: " + byteBuffer.toString());
            // 数据写入Buffer
            byteBuffer.put("你好，世界！\n".getBytes(StandardCharsets.UTF_8));
            System.out.println("put后: " + byteBuffer.toString());
            // Buffer -> Channel
            //limit = position;
            //position = 0;
            //mark = -1;
            byteBuffer.flip();
            System.out.println("flip后: " + byteBuffer.toString());
            while (byteBuffer.hasRemaining()) {
                channel.write(byteBuffer);
                System.out.println("write后: " + byteBuffer.toString() + byteBuffer.array().length);
            }

            channel.position(0); // 移动文件指针到开头（从头读取）
            CharBuffer charBuffer = CharBuffer.allocate(10);
            System.out.println("charBuffer allocate后: " + charBuffer.position() + " capacity = " +charBuffer.capacity() + " limit = " + charBuffer.limit());
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

            // 读出所有数据
            byteBuffer.clear();
            System.out.println("byteBuffer clear后: " + byteBuffer.toString());
            while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
                byteBuffer.flip();
                System.out.println("byteBuffer flip后: " + byteBuffer.toString());
                // 使用UTF-8解码器解码
                charBuffer.clear();
                System.out.println("charBuffer clear后: " + charBuffer.position() + " capacity = " +charBuffer.capacity() + " limit = " + charBuffer.limit());
                decoder.decode(byteBuffer, charBuffer, false);
                System.out.print(charBuffer.flip().toString());

                byteBuffer.compact(); // 数据可能有剩余
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
