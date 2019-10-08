package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Print Distinct Numbers</h1>
 * Write a program that reads in ten numbers and displays the number of distinct numbers and the distinct numbers
 * separated by exactly one space (i.e., if a number appears multiple times, it is displayed only once).
 *
 * (Hint: Read a number and store it to an array if it is new. If the number is already in the array, ignore it.)
 * After the input, the array contains the distinct numbers.
 * **/
public class Exercise07_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");

        int[] distinctNums = new int[0];
        for (int i = 0; i < 10; i++) {
            int val = input.nextInt();
            if (!contains(distinctNums, val)) {
                distinctNums = appendArray(distinctNums, val);
            }
        }

        System.out.printf("The number of distinct numbers is %d\n", distinctNums.length);

        System.out.print("The distinct numbers are: ");
        for (int val : distinctNums) {
            System.out.printf("%d ", val);
        }
        System.out.println();
    }

    private static int[] appendArray(int[] arr, int val) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = val;
        return newArr;
    }

    private static boolean contains(int[] arr, int val) {
        if (arr.length > 0) {
            for (int elem : arr) {
                if (elem == val) {
                    return true;
                }
            }
        }
        return false;
    }
}
