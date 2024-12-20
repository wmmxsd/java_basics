package com.wmm.basics.io;


import java.net.URI;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI uri = new URI("file:///C:/test1/test2");
        Path path = Paths.get(uri);
        Files.createDirectories(path);

        Files.createDirectories(Paths.get("C:\\test1\\test2\\test3"));
    }
}
