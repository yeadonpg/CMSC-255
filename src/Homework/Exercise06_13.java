/*
Sum
 */

package Homework;

public class Exercise06_13 {
    public static void main(String[] args) {
        System.out.println("i m(i)");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d %.4f\n", i, m(i));
        }
    }

    // m(i) = 1/2 + 2/3 + 3/4 + ... + i/(i+1)
    public static double m(int i) {
        double total = 0;
        for(int j = 1; j <= i; j++) {
            total += ((double) j/(j+1));
        }
        return total;
    }
}
