package Lab_8;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");
        String[] customerName = new String[7];

        for (int i = 0; i < tokens.length; i++) {
            customerName[i] = tokens[i];
        }

        printArr(customerName);

        moveElem(customerName, 3, 5);
        moveElem(customerName, 4, 6);
        copyElemOver(customerName, 2, 3);
        customerName[4] = "Jessica";
        printArr(customerName);

        removeItemAtIndex(customerName, "Rick");
        printArr(customerName);

        customerName = reverse(customerName);
        printArr(customerName);

    }

    public static void printArr(String[] arr) {
        for (String elem : arr) {
            System.out.println(elem);
        }
        System.out.println("");
    }

    public static void moveElem(String[] arr, int staIndex, int destIndex) {
        String temp = arr[staIndex];
        arr[staIndex] = arr[destIndex];
        arr[destIndex] = temp;
    }

    public static void copyElemOver(String[] arr, int staIndex, int destIndex) {
        arr[destIndex] = arr[staIndex];
    }

    public static void removeItemAtIndex(String[] arr, String elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(elem)) {
                arr[i] = null;
                // Moving elements to the start of the array
                for (int j = i + 1; j < arr.length; j++) {
                    moveElem(arr, j, j - 1);
                }
                i--;
            }
        }
    }

    public static String[] reverse(String[] arr) {
        String[] newArr = new String[arr.length];
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            newArr[j] = arr[i];
            j--;
        }
        return newArr;
    }
}
