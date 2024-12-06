package com.wmm.basics.innerclass.control_framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2021/1/5 17:40
 */
public class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (!eventList.isEmpty()) {
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}