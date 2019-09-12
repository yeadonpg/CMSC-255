/*
Vowel or Consonant?

Determines whether the letter entered by the user is
a vowel or a consonant.
For non-letter inputs, display invalid input.

Program Overview:
-
 */

package Homework;

import java.util.Scanner;

public class Exercise04_13 {
    public static void main(String[] args) {
        // Initializing the scanner
        Scanner input = new Scanner(System.in);

        // Getting input from the user
        System.out.println("Enter a letter grade: ");
        char userChar = input.next().charAt(0);

        // Validating that user entered a letter
        if (Character.isLetter(userChar)) {
            // Checking whether the character is a vowel or consonant
            switch (Character.toUpperCase(userChar)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'Y':
                    System.out.println(userChar + " is a vowel");
                    break;
                default:
                    System.out.println(userChar + " is a consonant");
            }
        } else {
            System.out.println(userChar + " is an invalid input");
        }
    }
}
