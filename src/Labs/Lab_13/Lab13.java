package Labs.Lab_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab13 {

    /**
     * <h2>Main Method</h2>
     * Takes an input file, and reads the values stored in each line<br>
     * File lines represent data on soccer teams; in the format:<br><br>
     * <code>
     *     ...<br>
     *     [Team Name],[Number of Scores],[Number of Shots]\n<br>
     *     [Team Name],[Number of Scores],[Number of Shots]\n<br>
     *     [Team Name],[Number of Scores],[Number of Shots]\n<br>
     *     ...<br><br>
     * </code>
     * While the data values are being read, the program calculates the best and worst team, as well as the average
     * number of goals scored across all teams
     * **/
    public static void main(String[] args) {

        try {
            // Initialize fileNames, inputs, and outputs
            String inputFileName = "src/Labs/Lab_13/soccerStats.txt";
            String outputFileName = "src/Labs/Lab_13/soccerSummary.txt";
            File inputFile = new File(inputFileName);
            Scanner in = new Scanner(inputFile);
            PrintWriter out = new PrintWriter(outputFileName);

            // Initialize values used for calculations
            double maxGoals = 0;
            String maxGoalsTeam = "";
            double minGoals = 1000;
            String minGoalsTeam = "";
            double totalNumShots = 0;
            int numTeams = 0;
            double averageNumShots;

            // Looping line-by-line over the input file
            while(in.hasNextLine()) {

                // Getting splitting the line by commas
                String nextAvailableLine = in.nextLine();
                String[] nextAvailableLineData = nextAvailableLine.split(",");

                // Parsing the line into the proper data types
                String curTeam = nextAvailableLineData[0];
                double curNumGoals = Double.parseDouble(nextAvailableLineData[1]);
                totalNumShots += Double.parseDouble(nextAvailableLineData[2]);

                // Incrementing the number of teams; used for calculating averageNumShots
                numTeams++;

                // Setting the new maxes and mins, if the current data is a new record of either
                if (curNumGoals > maxGoals) {
                    maxGoals = curNumGoals;
                    maxGoalsTeam = curTeam;
                } else if (curNumGoals < minGoals) {
                    minGoals = curNumGoals;
                    minGoalsTeam = curTeam;
                }
            }

            // Calculating the average number of shots per game
            averageNumShots = totalNumShots / numTeams;

            // Printing the formatted data into the output file
            out.printf("" +
                    "Maximum goals Scored: %s %.0f\n" +
                    "Minimum goals Scored: %s %.0f\n" +
                    "Average shots per Game: %.3f\n", maxGoalsTeam, maxGoals,  minGoalsTeam, minGoals, averageNumShots);
            // Closing the output PrintWriter to save properly
            out.close();


        }
        catch(FileNotFoundException ignored){

        }
    }
}
