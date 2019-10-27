package Project_5;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.copyOf;

/**
 * <h1>Programming Project 5 – Travel Distances</h1>
 *
 * Implementing search functionality for 2D arrays
 *
 * Patrick Yeadon
 * 10-15-2019
 * CMSC-255-001
 * **/
public class TravelDistances {
    public static void main(String[] args) {
        // 1. Parse the following inputs from the user, in order:
        Scanner input = new Scanner(System.in);

        // - String; containing cities, separated by commas
        String arg1 = args[0];
        // - String; containing distances from each city (format: dist1,dist2<>dist1,dist2)
        String arg2 = args[1];

        // - Compile the string to a 1D array:
        String[] cities = getCity(arg1);
        // - Compile the string to a 2D array:
        int[][] distances = getDistance(arg2);

        System.out.println("Type true if you would like to search cities above a certain distance or false if you would like to search cities below a certain distance: ");
        // - Boolean; whether to search above or below the given distance
        boolean userAnswer = input.nextBoolean();
        input.nextLine();

        System.out.println("Enter the distance you would like to search: ");
        // - Integer; the maximum or minimum distance between cities
        int userDistance = input.nextInt();
        input.nextLine();

        System.out.println("Enter the city you would like to start from: ");
        // - String; the city the user wants to search distances from
        String userCity = input.nextLine();

        // 2. Compile a list of cities that meet the given criteria, excluding the city being measured from:
        String[] matches = searchDistance(distances, cities, userAnswer, userDistance, userCity);

        // 3. Display the list of matches to the user
        System.out.println(Arrays.toString(matches));
    }

    /************************************************************************************************************************
     * String[] matches = searchDistance(String[] cities, int[][] distances, boolean aboveVal, int aDistance, String aCity) {
     *     String[] output = {}
     *     int aCityIndex = int getIndex(cities, aCity)
     *
     *     IF (aboveVal) {
     *         FOR (int i = 0; i < cities.length; i++) {
     *             int distance = distances[aCityIndex][i]
     *             IF (distance >= aDistance && !cities[i].equals(aCity)) {
     *                 output.append(cities[i])
     *             } END IF
     *         } END FOR
     *     ELSE
     *         FOR (int i = 0; i < cities.length; i++) {
     *             IF (distance <= aDistance && !cities[i].equals(aCity)) {
     *                 output.append(cities[i])
     *             } END IF
     *         } END FOR
     *     } END IF
     * } END searchDistance
     * **********************************************************************************************************************/
    public static String[] searchDistance(int[][] distances, String[] cities, boolean aboveVal, int aDistance, String aCity) {
        String[] output = new String[0];
        int aCityIndex = getIndex(cities, aCity);

        for (int i = 0, j = 0; i < cities.length; i++) {
            int distance = distances[aCityIndex][i];
            if (aboveVal) {
                if (distance >= aDistance && !cities[i].equals(aCity)) {
                    output = copyOf(output, output.length + 1);
                    output[j] = cities[i];
                    j++;
                }
            } else {
                if (distance <= aDistance && !cities[i].equals(aCity)) {
                    output = copyOf(output, output.length + 1);
                    output[j] = cities[i];
                    j++;
                }
            }
        }

        return output;
    }

    /**********************************************
     * getIndex(cities, aCity) {
     *    FOR (int i = 0; i < cities.length; i++) {
     *        IF (cities[i].equals(aCity)) {
     *            RETURN i
     *        } END IF
     *    } END FOR
     *    RETURN -1;
     * } END getIndex
     * ********************************************/
    private static int getIndex(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /***************************************
     * BEGIN getCity(inputCityString) {
     *     RETURN inputCityString.split(",")
     * } END getCity
     * ************************************/
    public static String[] getCity(String inputCityString) {
        return inputCityString.split(",");
    }

    /******************************************************************
     * BEGIN getDistance(String inputDistanceString) {
     *     int[][] output = {}
     *     String[] unsplitDistances = inputDistanceString.split("<>")
     *
     *     FOR (int i - 0; i < unsplitDistances.length; i++) {
     *         String[] splitDistances = getCity(unsplitDistances[i])
     *         FOR (int j = 0; j < splitDistances.length; j++) {
     *             output.append(toInteger(splitDistances[j]))
     *         } END FOR
     *     } END FOR
     *     RETURN output
     * } END getDistance
     * *************************************************************/
    public static int[][] getDistance(String inputDistanceString) {
        int[][] output = new int[0][0];
        String[] unsplitDistances = inputDistanceString.split("<>");

        for (int i = 0; i < unsplitDistances.length; i++) {
            String[] splitDistances = getCity(unsplitDistances[i]);

            output = copyOf(output, output.length + 1);
            output[i] = new int[splitDistances.length];
            for (int j = 0; j < splitDistances.length; j++) {
                int val = Integer.parseInt(splitDistances[j]);
                output[i][j] = val;
            }
        }
        return output;
    }
}
