package Labs.Lab_6;

import java.util.Scanner;

public class NestedLoopTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numRows = input.nextInt();

        for (int j = 1; j <= numRows; j++) {
            System.out.print("*");
            for (int i = 1; i < j; i++) {
                System.out.print("**");
            }
            System.out.println();
        }

        for (int j = 1; j <= numRows; j++) {
            int numSpaces = numRows - j;
            for (int i = 1; i <= numSpaces; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int k = 1; k < j; k++) {
                System.out.print("**");
            }
            System.out.println();
        }
    }
}
