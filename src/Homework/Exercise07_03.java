package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Count occurrences of numbers</h1>
 * Write a program that reads integers between 1 and 100 and counts the occurrences of each
 * Assume input ends with 0
 * **/
public class Exercise07_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100: ");
        String userAnswer = input.nextLine();
        int[] nums = new int[0];
        int[] numOccurrances = new int[101];

        int i = 0;
        do {
            int val = Integer.parseInt(userAnswer.split(" ")[i]);

            if (val < 1) {
                break;
            }

            numOccurrances[val]++;
            nums = appendArr(nums, val);
            i++;
        } while(true);

        nums = removeDuplicates(nums);
        nums = sorted(nums);

        for (int j = 0; j < nums.length; j++) {
            String multiple = "";
            if (numOccurrances[nums[j]] > 1) {
                multiple = "s";
            }
            System.out.printf("%d occurs %d time%s\n", nums[j], numOccurrances[nums[j]], multiple);
        }
    }

    private static int[] appendArr(int[] arr, int val) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = val;
        return newArr;
    }

    private static boolean arrContains(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }

    private static int[] removeDuplicates(int[] arr) {
        int[] newArr = new int[0];
        int[] prevNums = new int[] {-1};
        for (int i = 0; i < arr.length; i++) {
            if (!arrContains(prevNums, arr[i])) {
                prevNums = appendArr(prevNums, arr[i]);
                newArr = appendArr(newArr, arr[i]);
            }
        }
        return newArr;
    }

    private static int[] sorted(int[] originalArr) {
        int[] arr = Arrays.copyOf(originalArr, originalArr.length);
        int numMoves = 0;
        do {
            numMoves = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 < arr.length) {
                    int score1 = arr[i];
                    int score2 = arr[i + 1];
                    if (score2 < score1) {
                        numMoves++;
                        arr[i] = score2;
                        arr[i + 1] = score1;
                    }
                }
            }
        } while (numMoves > 0);
        return arr;
    }
}
