/*
Programming Project 3 - Tri Circle Sign

Calculating the cost of a custom sign containing text

Patrick Yeadon
09-13-2019
CMSC-255-001
 */

package Project_3;

import java.util.Scanner;
import java.lang.Math;

public class TriCircleSign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean userContinue = true;

        while (userContinue) {
            // User inputs the length of a triangle side
            System.out.println("Enter the length of a side of your triangle:");
            double sideLen = input.nextDouble();
            input.nextLine();

            // User inputs their desired custom text
            System.out.println("Enter the string you would like on your sign:");
            String signText = input.nextLine();

            // Calculate the number of non-blank characters
            String signTextNoSpaces = signText.replaceAll("\\s", "");
            int signCharacters = signTextNoSpaces.length();

            // Calculate the area of a circle containing an equilateral triangle of the given side length
            double s = (3.0 * sideLen) / 2.0;
            double radius = Math.pow(sideLen, 3) / (4 * Math.sqrt(s * Math.pow((s - sideLen), 3)));
            double area = Math.PI * radius * radius;

            // Calculate the total cost of the sign using the area and number of characters
            final double costPerSquareFoot = 2.35;
            final double costPerCharacter = 1.45;
            double totalCost = (costPerSquareFoot * area) + (costPerCharacter * signCharacters);

            // Print the total cost, rounded to two decimal places
            System.out.printf("$%.2f\n", totalCost);

            // User inputs whether or not they'd like the program to restart
            System.out.println("Would you like to create another sign? Enter quit to exit.");
            String userChoice = input.nextLine().trim();

            // If the user enters "quit", the program will end; otherwise it will restart
            if (userChoice.equals("quit")) {
                userContinue = false;
            }
        }
    }
}
