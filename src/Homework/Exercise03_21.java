package Homework;

import java.util.Scanner;

public class Exercise03_21
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Enter year: (e.g., 2012): ");
        int year = input.nextInt();
        System.out.printf("Enter month: 1-12: ");
        int month = input.nextInt();
        System.out.printf("Enter the day of the month: 1-31: ");
        int day = input.nextInt();

        if (month < 3)
        {
            month += 12;
            year -= 1;
        }

        int centuryYear = year % 100;

        int weekday = (day + ((26 * (month + 1)) / 10) + centuryYear + (centuryYear / 4) + ((year / 100) / 4) + (5 * (year / 100))) % 7;

        switch (weekday) {
            case 0:
                System.out.println("Day of the week is Saturday");
                break;
            case 1:
                System.out.println("Day of the week is Sunday");
                break;
            case 2:
                System.out.println("Day of the week is Monday");
                break;
            case 3:
                System.out.println("Day of the week is Tuesday");
                break;
            case 4:
                System.out.println("Day of the week is Wednesday");
                break;
            case 5:
                System.out.println("Day of the week is Thursday");
                break;
            case 6:
                System.out.println("Day of the week is Friday");
                break;
        }

        input.close();
    }
} 