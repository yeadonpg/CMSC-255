package Homework;

import java.util.Scanner;
import java.lang.Math;

public class Exercise02_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter investment amount: ");
        double investmentAmount = in.nextDouble();

        System.out.printf("Enter annual interest rate in precentage: ");
        double interestRate = in.nextDouble();

        System.out.printf("Enter number of years: ");
        double years = in.nextDouble();

        interestRate = interestRate / 100.0 / 12.0;

        double futureValue = investmentAmount * Math.pow(1 + interestRate, years * 12.0);
        System.out.println("Accumulated value is $" + futureValue);
    }
}