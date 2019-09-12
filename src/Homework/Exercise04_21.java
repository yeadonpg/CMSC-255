/*
Check SSN

Program Outline:
- Prompt the user to enter a SSN in the format:
    DDD-DD-DDDD
    - D is a numerical digit
- Check whether the input is valid, and output:
    "<SSN> is a valid/invalid social security number"
 */

package Homework;

import java.util.Scanner;

public class Exercise04_21 {
    public static void main(String[] args) {
        // Initializing scanner
        Scanner input = new Scanner(System.in);

        // Getting an input from the user
        System.out.println("Enter a SSN: ");
        String userSSN = input.next();

        // Validating userSSN by looping over each character
        // Check that each character is the correct type
        // If any character is out of place, validSSN is set to false
        boolean validSSN = true;
        for (int index = 0; index < userSSN.length(); index++) {
            char currentChar = userSSN.charAt(index);

            if ((index == 3 || index == 6) && currentChar != '-') {
                validSSN = false;
            } else if ((index != 3 && index != 6) && !Character.isDigit(currentChar)) {
                validSSN = false;
            }
        }

        // Printing the conclusion
        if (validSSN) {
            System.out.println(userSSN + " is a valid social security number");
        } else {
            System.out.println(userSSN + " is an invalid social security number");
        }

        input.close();
    }
}
