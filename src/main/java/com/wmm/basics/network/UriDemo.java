package com.wmm.basics.network;

import java.io.File;
import java.net.URI;

public class UriDemo {
    public static void main(String[] args) throws Exception {
        URI uri;
        String path = UriDemo.class.getResource("UriDemo.class").getPath();
        try {
            uri = new URI(path);
            System.out.println(uri);
            System.out.println(uri.isAbsolute());
            System.out.println(uri.toURL());
            System.out.println("uri.getHost()=" + uri.getHost());
            System.out.println("uri.getPath()=" + uri.getPath());
            System.out.println("uri.getPort()=" + uri.getPort());
            System.out.println("uri.getQuery()=" + uri.getQuery());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String filePath = "file://" + path;
            uri = new URI(filePath);
            System.out.println(uri);
            System.out.println(uri.isAbsolute());
            System.out.println(uri.toURL());
            System.out.println("uri.getHost()=" + uri.getHost());
            System.out.println("uri.getPath()=" + uri.getPath());
            System.out.println("uri.getPort()=" + uri.getPort());
            System.out.println("uri.getQuery()=" + uri.getQuery());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            uri = new URI("file:///" + path);
            System.out.println(uri);
            System.out.println(uri.isAbsolute());
            System.out.println(uri.toURL());
            System.out.println("uri.getHost()=" + uri.getHost());
            System.out.println("uri.getPath()=" + uri.getPath());
            System.out.println("uri.getPort()=" + uri.getPort());
            System.out.println("uri.getQuery()=" + uri.getQuery());
        } catch (Exception e) {
            System.out.println(e);
        }

        String logPath = "D:/code/gitlab/CCP/clientservice/externalResources/log4j2.xml";
        uri = new URI("file:///" + logPath);
        File logFile = new File(uri);
    }
}
