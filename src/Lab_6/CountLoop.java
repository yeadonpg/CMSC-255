package Lab_6;

import java.util.Scanner;

public class CountLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int numLoops = input.nextInt();

        int total = 0;
        for (int i = 1; i <= numLoops; i++) {
            total += i;
        }
        System.out.println("FOR Total: " + total);

        // Resetting total for use in WHILE loop
        total = 0;
        int i = 1;
        while(i <= numLoops) {
            total += i;
            i++;
        }
        System.out.println("WHILE Total: " + total);

        //Resetting total & i for use in DO WHILE loop
        total = 0;
        i = 1;
        do {
            total += i;
            i++;
        } while (i <= numLoops);
        System.out.println("DO WHILE Total: " + total);
    }
}
