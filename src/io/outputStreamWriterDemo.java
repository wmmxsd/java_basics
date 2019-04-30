package io;

import java.io.*;

public class outputStreamWriterDemo {
    public static void main(String[] args) {
        try (
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("./src/io/tmp3.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
            bufferedWriter.write("Hello Wolrd");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello Wolrd");
            bufferedWriter.newLine();
            bufferedWriter.write("Hello Wolrd");
            bufferedWriter.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
