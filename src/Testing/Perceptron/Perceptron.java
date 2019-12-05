package Testing.Perceptron;

import java.util.Scanner;

@SuppressWarnings("WeakerAccess")
public class Perceptron {

    /**
     * <h2>Main Method</h2>
     * Tests a basic Perceptron implementation, with pre-calculated weights<br>
     * The perceptron will decide whether a 3x3 grid of pixels (On or Off) contains a 1, or a 0<br>
     * <br>
     * Example grid:<br>
     * <code>
     *     0 1 0<br>
     *     0 1 0<br>
     *     0 1 0<br>
     * </code>
     * Contains a 1
     * **/
    public static void main(String[] args) {
        double[][][] smallGridChoices = {
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {1, 1, 0}
                },
                {
                        {0, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                },
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}
                },
                {
                        {0, 1, 0},
                        {1, 0, 1},
                        {0, 1, 0}
                }
        };

        // Initializing Scanner
        Scanner input = new Scanner(System.in);

        // Performing action for as long as the user wants to continue
        do {
            // Initializing inputGrid
            double[][] inputGrid = new double[3][3];

            // Prompting the user for input
            System.out.println("\nInput a grid below:\n" +
                    "Example Grid:\n" +
                    "\t001\n" +
                    "\t010\n" +
                    "\t100\n" +
                    "Your input grid must be 3x3:");

            // Parsing user input
            // For each row that the user enters, up to three rows
            boolean validInput = false;
            while (!validInput) {
                System.out.println("Awaiting Input...");
                for (int i = 0; i < 3; i++) {
                    // Parsing String row into individual characters
                    String[] userRow = input.nextLine().trim().split("");
                    // Testing whether ir not this row constitutes a correct grid
                    if (!containsBinary(userRow)) {
                        // If user enters an incorrect row, the user can choose to let the computer generate it, or go again
                        System.out.println("Entered an incorrect row!\n" +
                                "Do you want to continue entering your own grid? (y/n)");
                        String userChoice = input.nextLine();
                        // The user has chosen to try entering a grid again
                        if (userChoice.trim().equalsIgnoreCase("y")) {
                            validInput = false;
                            break;
                        }
                        // The user has chosen to let the computer generate a grid
                        System.out.println("Automatically generating a grid...");
                        inputGrid = smallGridChoices[(int) (Math.random() * 4)];
                        validInput = true;
                        break;
                    } else {
                        // Parsing the correct row into the inputGrid
                        for (int j = 0; j < userRow.length; j++) {
                            inputGrid[i][j] = Double.parseDouble(userRow[j]);
                        }
                        validInput = true;
                    }
                }
            }

            // Initializing neurons and weights
            System.out.println("\nInput grid:");
            print2DArray(inputGrid);

            // Setting neurons and weights
            double[] neurons = linearize(inputGrid);
            double[] weights = new double[]{2, 1, 2, 4, -4, 4, 2, -1, 2};
            double bias = -5;

            // Calculating output neuron
            double output = 0;
            for (int j = 0; j < neurons.length; j++) {
                output += neurons[j] * weights[j];
            }
            output += bias;

            // Displaying output
            if (output > 0) {
                System.out.println("This number is 0");
            } else {
                System.out.println("This number is 1");
            }

            System.out.println("Do you want to test again? (y/n)");
        } while (!input.nextLine().trim().equalsIgnoreCase("n"));
    }

    /**
     * <h2>containsBinary</h2>
     * Tests whether or not a 1D array of doubles contains only 1 and 0
     * @param arr The 1D array to be tested
     * @return The decided outcome
     * **/
    public static boolean containsBinary(String[] arr) {
        for (String elem : arr) {
            if (!(elem.equals("0") || elem.equals("1"))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <h2>print2DArray</h2>
     * Prints a 2D array, in the format of ⬛'s and ☐'s to signify On or Off
     * @param arr The 2D array entered by the user, or generated by the program
     * **/
    public static void print2DArray(double[][] arr) {
        for (double[] row : arr) {
            for (double val : row) {
                if (val == 0) {
                    System.out.print((char) 0x2610);
                } else {
                    System.out.print((char) 0x2B1B);
                }
            }
            System.out.println();
        }
    }

    /**
     * <h2>linearize</h2>
     * Maps a 2D array (of any size) to a 1D array with the same number of elements<br>
     * Essentially places the rows of the 2D array end-to-end, to form a 1D array
     * @param arr Input 2D Array
     * @return double[] A 1D Array
     * **/
    public static double[] linearize(double[][] arr) {
        double[] output = new double[arr.length * arr.length];
        int k = 0;
        for (double[] doubles : arr) {
            for (double aDouble : doubles) {
                output[k] = aDouble;
                k++;
            }
        }
        return output;
    }
}
