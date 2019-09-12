package Homework;

import java.util.Scanner;

public class Exercise02_07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double MINUTES_PER_HOUR = 60;
        double HOURS_PER_DAY = 24;
        double DAYS_PER_YEAR = 365;

        System.out.println("Enter the number of minutes: ");
        double minutes = in.nextDouble();
        double days = (minutes / MINUTES_PER_HOUR) / HOURS_PER_DAY;
        double years = days / DAYS_PER_YEAR;
        days = days % DAYS_PER_YEAR;

        System.out.println((int) minutes + " minutes is approximately " + (int) years + " years and " + (int) days + " days");
    }
}