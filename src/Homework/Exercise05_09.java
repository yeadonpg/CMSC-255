/*
Write a program that prompts the user to enter the number of students
and each student’s name and score, and finally displays the student
with the highest score and the student with the second-highest score.
Use the next() method in the Scanner class to read a name rather than
using the nextLine() method. Assume that the number of students is at
least 2.
 */

package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise05_09 {
    private static int findIndex(double[] arr, double val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        String[] students = new String[numStudents];
        double[] scores = new double[numStudents];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a student name: ");
            String studentName = input.next();
            System.out.print("Enter a student score: ");
            double studentScore = input.nextDouble();
            students[i] = studentName;
            scores[i] = studentScore;
        }
        double[] newScores = scores.clone();
        Arrays.sort(newScores);
        double topScore = newScores[numStudents - 1];
        double secondScore = newScores[numStudents - 2];
        String topStudent = students[findIndex(scores, topScore)];
        String secondStudent = students[findIndex(scores, secondScore)];
        System.out.println("Top two students:");
        System.out.println(topStudent + "'s score is " + topScore);
        System.out.println(secondStudent + "'s score is " + secondScore);
    }
}
