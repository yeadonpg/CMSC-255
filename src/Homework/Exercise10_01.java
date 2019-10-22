package Homework;

/**
 * <h1>The Time Class</h1>
 * - Automatically converts current time in milliseconds to proportionate value in hours, minutes, & seconds
 * **/
class Time {
    private double hour;
    private double minute;
    private double second;

    public long getHour() {
        return (long) hour % 24;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public long getMinute() {
        return (long) minute % 60;
    }

    public void setMinute(double minute) {
        this.minute = minute;
    }

    public long getSecond() {
        return (long) second % 60;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public Time() {
        double elapsedTimeMills = System.currentTimeMillis();
        setTime(elapsedTimeMills);
    }

    public Time(double elapsedTimeMills) {
        setTime(elapsedTimeMills);
    }

    public Time(double hour, double minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(double elapsedTime) {
        this.second = (elapsedTime / 1000);
        this.minute = (elapsedTime / 1000 / 3600);
        this.hour = (elapsedTime / 1000 / 3600 / 60);
    }
}

public class Exercise10_01 {
    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        System.out.printf("%d:%d:%d\n", time1.getHour(), time1.getMinute(), time1.getSecond());
        System.out.printf("%d:%d:%d\n", time2.getHour(), time2.getMinute(), time2.getSecond());
    }
}
