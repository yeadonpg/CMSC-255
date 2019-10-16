package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Exercise 07_01: Sorting Grades</h1>
 * Take the number of students from the user
 * Take a grade for each student from the user
 * Using the highest grade as a reference, grade every score on the curve
 * **/
public class Exercise07_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int totalStudents = input.nextInt();
        System.out.printf("Enter %d student scores, separated by a space: ", totalStudents);
        input.nextLine();
        String userAnswer = input.nextLine();
        double[] studentScores = new double[totalStudents];
        for (int i = 0; i < totalStudents; i++) {
            studentScores[i] = Double.parseDouble(userAnswer.split(" ")[i]);
        }
        double[] sortedScores = sorted(studentScores);
        gradeArray(sortedScores, studentScores);
    }

    private static double[] sorted(double[] originalArr) {
        double[] arr = Arrays.copyOf(originalArr, originalArr.length);
        int numMoves = 0;
        do {
            numMoves = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 < arr.length) {
                    double score1 = arr[i];
                    double score2 = arr[i + 1];
                    if (score2 > score1) {
                        numMoves++;
                        arr[i] = score2;
                        arr[i + 1] = score1;
                    }
                }
            }
        } while (numMoves > 0);
        return arr;
    }

    private static void gradeArray(double[] sortedArr, double[] arr) {
        int best = (int) sortedArr[0];
        for (int i = 0; i < arr.length; i++) {
            String grade = "F";
            int score = (int) arr[i];
            if (score >= best - 10) {
                grade = "A";
            } else if (score >= best - 20) {
                grade = "B";
            } else if (score >= best - 30) {
                grade = "C";
            } else if (score >= best - 40) {
                grade = "D";
            }
            System.out.printf("Student %d score is %d and grade is %s\n", i, score, grade);
        }
    }
}
