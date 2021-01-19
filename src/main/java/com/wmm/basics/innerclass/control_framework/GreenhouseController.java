package com.wmm.basics.innerclass.control_framework;

import com.wmm.basics.innerclass.control_framework.impl.GreenHouseControls;

/**
 * @author wangmingming160328
 * @date @2021/1/5 17:53
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        // Instead of using code, you could parse
        // configuration information from a text file:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.addEvent(new GreenHouseControls.Terminate(5000));
        gc.run();
    }
}
