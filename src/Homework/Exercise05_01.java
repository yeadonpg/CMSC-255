/*
Write a program that reads an unspecified number of integers,
determines how many positive and negative values have been read,
and computes the total and average of the input values (not counting zeros).
Your program ends with the input 0. Display the average as a floating-point number.
 */

package Homework;

import java.util.Scanner;

public class Exercise05_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        double average = 0;
        int posCount = 0;
        int negCount = 0;
        System.out.print("Enter an integer, the input ends if it is 0: ");
        String[] stringNumbers = input.nextLine().split("\\s");
        for (String stringNum : stringNumbers) {
            int num = Integer.parseInt(stringNum);
            total += num;
            if (num > 0) {
                posCount++;
            } else if (num < 0) {
                negCount++;
            } else {
                break;
            }
        }
        if (total != 0 || stringNumbers.length > 1) {
            average = (double) total / (posCount + negCount);
            System.out.println("The number of positives is " + posCount);
            System.out.println("The number of negatives is " + negCount);
            System.out.println("The total is " + total);
            System.out.println("The average is " + average);
        } else {
            System.out.println("No numbers are entered except 0");
        }
    }
}
