/*
Investment Calculator
- Enter the investment amount and the annual rate
 */

package Homework;

import java.util.Scanner;

public class Exercise06_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("The amount invested: ");
        double userInvestment = input.nextDouble();
        input.nextLine();

        // Rate entered in percent (e.g. 9% = 9)
        System.out.print("Annual interest rate: ");
        double userRate = input.nextDouble();
        userRate /= 100;

        System.out.println("Years Future Value");
        for (int i = 1; i <= 30; i++) {
            System.out.printf("%d %.2f\n", i, futureInvestmentValue(userInvestment, userRate/12, i));
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12.0);
    }
}
