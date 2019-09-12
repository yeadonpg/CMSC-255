/*
Days of a Month

Program Overview:
- Prompt the user to enter a year & the 1st three letters of a month name
- If the input is incorrect, display "<month> is not a correct month name"
- Display the number of days in that month
 */

package Homework;

import java.util.Scanner;

public class Exercise04_17 {
    public static void main(String[] args) {
        // Initializing the scanner
        Scanner input = new Scanner(System.in);

        // Getting user input
        System.out.println("Enter a year: ");
        int year = input.nextInt();
        System.out.println("Enter a month: ");
        String month = input.next();

        // Determining the correct conclusion
        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                System.out.println(month + " " + year + " has 31 days");
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                System.out.println(month + " " + year + " has 30 days");
                break;
            case "Feb":
                if (year % 4 == 0) {
                    System.out.println("Feb " + year + " has 29 days");
                } else {
                    System.out.println("Feb " + year + " has 28 days");
                }
                break;
            default:
                System.out.println(month + " is not a correct month name");
        }
        input.close();
    }
}
