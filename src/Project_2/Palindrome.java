/*
Palindrome
****************************************************************
Assessing whether a number is a palindrome, with user interaction
****************************************************************
Patrick Yeadon
09-03-2019
CMSC-255-001
*/

package Project_2;

import java.util.Scanner;
import java.lang.Math;

public class Palindrome
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        /*
        number = 0 // Placeholder value

        correctAnswer = false

        PRINT "Enter 1 if you would like to enter a 3-digit number."
        PRINT "Enter 2 if you would like to have the computer generate it."
        generateOrManual = INPUT
        */

        int number = 0; // Placeholder value

        boolean correctAnswer = false;

        System.out.println("Enter 1 if you would like to enter a 3-digit number. Enter 2 if you would like to have the computer generate it.");
        int generateOrManual = in.nextInt();

        /*
        IF generateOrManual == 1: // User chose to input manually
            PRINT "Enter the 3-digit number:"
            number = INPUT
        */

        if(generateOrManual == 1) // User chose to input manually
        {
            System.out.println("Enter the 3-digit number:");
            number = in.nextInt();

            /*
            IF 99 < number < 1000: // Number is inside valid range
                correctAnswer = true

            ELSE // No valid answer was chosen for the 2nd question
                PRINT "Incorrect Input"

            END IF
            */

            if(number > 99 && number < 1000) // Number is inside valid range
            {
                correctAnswer = true;
            }
            else // No valid answer was chosen for the 2nd question
            {
                System.out.println("Incorrect input");
            }
        }

        /*
        ELSE IF generateOrManual == 2: // User chose to let computer generate a 3-digit number
            number = RandomIntegerBetween(100, 999)
            PRINT number
            correctAnswer = true
        */
        
        else if(generateOrManual == 2) // User chose to let the computer generate a 3-digit number
        {
            number = (int)(Math.random() * 899) + 100;
            System.out.println(number);
            correctAnswer = true;
        }

        /*
        ELSE: // No valid answer was chosen for the 1st question
            PRINT "Incorrect Input"

        END IF
        */

        else // No valid answer was chosen for the 1st question
        {
            System.out.println("Incorrect input");
        }

        /*
        // Convert integer to string to get 1st character, then convert back to integer
        firstDigit = |number|.toString()[0].toInteger()
        lastDigit = number % 10
        */

        // Convert integer to string to get 1st character, then convert back to integer
        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
        int lastDigit = number % 10;

        /*
        IF correctAnswer:
            IF firstDigit == lastDigit:
                PRINT number + " is a palindrome"

            ELSE:
                PRINT number + " is not a palindrome"

            END IF

        END IF
        */

        if(correctAnswer) // Comparing the digits and outputting a verdict
        {
            if(firstDigit == lastDigit)
            {
                System.out.println(number + " is a palindrome");
            }
            else
            {
                System.out.println(number + " is not a palindrome");
            }
        }

        in.close();
    }
}