package Homework;

import java.util.Scanner;

/**
 * <h1>Binary to Decimal</h1>
 * Write a program to parse a string that contains a binary number.
 * If the string doesn't contain a binary number, print "Not a binary number: <numberInput>"
 * **/
@SuppressWarnings("WeakerAccess")
public class Exercise12_07 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String userInput = input.nextLine();

        try {
            System.out.println(bin2Dec(userInput));
        // Catching the method's exception to provide a graceful error message
        } catch (NumberFormatException e) {
            System.out.println("Not a binary number: " + userInput);
        }
    }

    /**
     * <h2>bin2Dec(String binaryString)</h2>
     * Converts a binary string to a decimal number, and prints it
     * @param binaryString String containing a binary number
     * @return The calculated decimal number
     * **/
    public static int bin2Dec(String binaryString) throws NumberFormatException {
        int output = 0;
        int length = binaryString.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = binaryString.charAt(length - 1 - i);
            if (c == '0' || c == '1') {
                if (c == '1') {
                    output += Math.pow(2, i);
                }
            } else {
                throw new NumberFormatException("Not a binary number: " + binaryString);
            }
        }
        return output;
    }
}