/*
Geometry: Area of a Regular Polygon

The formula for computing the area of a regular polygon is:

area = n * s^ 2 / (4 * tan ( pi / n ))
- Where s is the length of a side

Program Outline:
- Prompt the user to enter the # of sides & their length
- Return the area of the regular polygon, using the formula
 */

package Homework;

import java.lang.Math;
import java.util.Scanner;

public class Exercise04_05 {
    public static void main(String[] args) {
        // Initializing scanner
        Scanner input = new Scanner(System.in);

        // Getting the number of sides & side length from user
        System.out.println("Enter the number of sides: ");
        double numSides = input.nextDouble();
        System.out.println("Enter the length of a side: ");
        double sideLength = input.nextDouble();

        // Calculating the area of the regular polygon based on the formula:
        // area = n * s^ 2 / (4 * tan ( pi / n ))
        double area = numSides * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / numSides));
        System.out.println("The area of the polygon is " + area);

    }
}
