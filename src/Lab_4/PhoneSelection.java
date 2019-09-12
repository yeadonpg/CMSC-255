/*
Patrick Yeadon & Jonathan Fung
CMSC-255-001
 */

package Lab_4;

import java.util.Scanner;

public class PhoneSelection {
    public static void main(String[] args) {
        // Declaring scanner
        Scanner scnr = new Scanner(System.in);
        // Getting, and capitalizing the first character of user input
        System.out.println("Enter a single letter, and I will tell you what the corresponding digit is on the telephone");
        char userChar = scnr.next().toUpperCase().charAt(0);

        // Making a conclusion based on the user input
        switch (userChar) {
            case 'A':
            case 'B':
            case 'C':
                System.out.println("The digit 2 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'D':
            case 'E':
            case 'F':
                System.out.println("The digit 3 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'G':
            case 'H':
            case 'I':
                System.out.println("The digit 4 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'J':
            case 'K':
            case 'L':
                System.out.println("The digit 5 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'M':
            case 'N':
            case 'O':
                System.out.println("The digit 6 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                System.out.println("The digit 7 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'T':
            case 'U':
            case 'V':
                System.out.println("The digit 8 corresponds to the letter " + userChar + " on the telephone.");
                break;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                System.out.println("The digit 9 corresponds to the letter " + userChar + " on the telephone.");
                break;
        }
        scnr.close();
    }
}
