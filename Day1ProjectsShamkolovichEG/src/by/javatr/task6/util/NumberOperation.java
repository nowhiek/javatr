package by.javatr.task6.util;

import java.util.concurrent.TimeUnit;

public class NumberOperation {

    public static String getCurrentTimeFromSeconds(long seconds){
        long hours = TimeUnit.SECONDS.toHours(seconds);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);

        StringBuilder sb = new StringBuilder();

        sb.append(hours + ":" + minute + ":" + second);

        return sb.toString();
    }
}
