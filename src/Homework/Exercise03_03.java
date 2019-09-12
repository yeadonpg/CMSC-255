package Homework;

import java.util.Scanner;

/****************************************************************************************
Solve 2x2 Linear Equations
Given two linear equations:
ax + by = e
cx + dy = f

x and y can be solved using Cramer's Rule as shown:
determinate_A = a * d - b * c
determinate_B = e * d - b * f
determinate_C = a * f - e * c
x = determinate_B / determinate_A
y = determinate_C / determinate_A 

if determinate_A is zero, there is no solution to the system

Given 6 numbers input by the user, determine the respective values of x and y is possible
****************************************************************************************/

public class Exercise03_03
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Getting the values for a, b, c, d, e, & f from the user:
        // Numbers are entered in one line, separated by spaces
        System.out.printf("Enter a, b, c, d, e, f: ");
        String answer = input.nextLine();

        // Splitting the original string to isolate each number
        String[] numbers = answer.split(" ");

        // Continuing only if the user entered six numbers
        if (numbers.length == 6)
        {
            // Extracting numerical values from the split up original string
            double a = Double.valueOf(numbers[0]);
            double b = Double.valueOf(numbers[1]);
            double c = Double.valueOf(numbers[2]);
            double d = Double.valueOf(numbers[3]);
            double e = Double.valueOf(numbers[4]);
            double f = Double.valueOf(numbers[5]);

            // Calculating the value of determinate_A
            double detA = a * d - b * c;
            if (detA != 0) // Non-zero determinant
            {
                // Calculating the rest of Cramer's Rule
                double detB = e * d - b * f;
                double detC = a * f - e * c;
                double x = detB / detA;
                double y = detC / detA;
                System.out.println("x is " + x + " and y is " + y);
            }
            else // Determinant is zero, therefore no solution
            {
                System.out.println("The equation has no solution");
            }
        }
        
        input.close();
    }
}