package com.wmm.basics.compare;

import java.util.Arrays;

/**
 * @author wangmingming160328
 * @date @2020/7/24 11:42
 */
public class App {
    public static void main(String[] args) {
        User user1 = new User(22, 22);
        User user2 = new User(23, 34);
        User user3 = new User(2, 2);
        User[] users = {user1, user2, user3};
        Arrays.sort(users);
        Arrays.stream(users).forEach(System.out::println);
    }
}
