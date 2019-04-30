package io;

import java.io.*;
import java.nio.charset.Charset;

public class inputStreamReaderDemo {
    public static void main(String[] args) {
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("./src/io/tmp3.txt"), Charset.defaultCharset())){
            BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
