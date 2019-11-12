package Testing.Sequences;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * <h2>Experiment with the Fibonacci Sequence</h2> Calculates the Fibonacci sequence traditionally, and using a
 * function; calculates the error between the actual sequence and the functionally generated version.
 * <h3>See More:</h3> See docs for the method: <br><code>Fibonacci.F(int n)</code><br> to get more
 * details and observations on the functionality of this program.
 * @version 1.0
 * @since Nov. 11, 2019
 * @author Patrick Yeadon
 * **/
public class Fibonacci {
    /**
     * <h2>Main Method</h2>
     * Calculates & prints the % difference, and absolute difference, between the traditionally generated sequence, and
     * the functionally generated sequence. Prints are made after each step in the sequence is calculated.
     * **/
    public static void main(String[] args) throws InterruptedException {
        // Initializing the elements needed to calculated the Fibonacci sequence exactly
        ArrayList<Long> f = new ArrayList<>();
        f.add((long) 1);
        f.add((long) 1);
        int i = 0;
        int j = 100;

        // Calculate the Fibonacci numbers up to the j'th term
        while (i <= j) {
            int getIndex = i + 1;

            // Calculating the Fibonacci sequence via standard means, to give a correct value to compare against
            f.add(f.get(i) + f.get(i + 1));

            long n = F(i);

            double diff = ((f.get(getIndex) - Math.floor(n)) / f.get(getIndex));
            System.out.print(String.format("%d: dif: %.7f", i, diff * 100) + "%");
            System.out.println(String.format(" absDif: %.1f", f.get(getIndex) - Math.floor(n)));
            i++;

            // Telling the program to sleep for 100ms, to save processing power and help visualize numbers in System.out
            sleep(100);
        }
    }

    /**
     * <h2>Benet's Formula</h2>
     * Named after Jacques Philippe Marie Binet (1786-1856)
     * <h3>Operational Observations:</h3>
     * At step 70, the function begins to diverge from the correct sequence (That is if my sequence is correct, which I
     * am pretty sure of). At step 91, the program hits an uncaught overflow error; suddenly slipping to a negative
     * number.
     * @param n Sequence index to be used for calculation
     * @return long - The calculated output of the formula
     * **/
    public static long F(int n) {
        return (long) Math.floor((1 / Math.sqrt(5)) * (Math.pow((1 + Math.sqrt(5))/2, n + 2) - Math.pow((1 - Math.sqrt(5))/2, n + 2)/2));
    }
}
