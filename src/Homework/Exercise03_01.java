package Homework;

import java.util.Scanner;
import java.lang.Math;

/***********************************************************************************************************
Solving Quadratic Equations
The two roots of a quadratic equation can be obtained using the following formula:
Given: ax^2 + bx + c + 0

r1 = (-b + sqrt(b^2 - 4ac)) / 2a
r2 = (-b - sqrt(b^2 - 4ac)) / 2a

b^2 - 4ac is called the discriminant of the quadratic equation.

If it is positive, the equation has two real roots.
If it is zero, the equation has one root.
If it is negative, the equation has no real roots.

Given 3 numbers input by the user, determine the discriminant and the number of roots, then print each root
**********************************************************************************************************/

public class Exercise03_01
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Getting the values for a, b, & c from the user:
        // Numbers are entered in one line, separated by spaces
        System.out.printf("Enter a, b, c: ");
        String answer = input.nextLine();

        // Splitting the original string to isolate each number
        String[] numbers = answer.split(" ");

        // Continuing only if the user entered three numbers
        if (numbers.length == 3)
        {
            // Extracting numerical values from the split up original string
            double a = Double.valueOf(numbers[0]);
            double b = Double.valueOf(numbers[1]);
            double c = Double.valueOf(numbers[2]);

            // Determining the discriminant and the roots based on the rules in the overview:
            double discriminant = Math.pow(b, 2) - 4 * a * c;

            if (discriminant > 0) // Two roots
            {
                double r1 = (double) (-b + Math.pow(discriminant, 0.5)) / (double) (2 * a);
                double r2 = (double) (-b - Math.pow(discriminant, 0.5)) / (double) (2 * a);
                System.out.println("The system has two roots " + r1 + " and " + r2);

            }
            else if (discriminant == 0) // One root
            {
                double r1 = (double) (-b + Math.pow(discriminant, 0.5)) / (double) (2 * a);
                System.out.println("The system has one root " + r1);

            }
            else // No roots
            {
                System.out.println("The system has no real roots");
            }

            input.close();
        }
    }
}