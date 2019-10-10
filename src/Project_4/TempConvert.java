/*
Temperature Conversions

Converting user-given temperatures to another scale

Patrick Yeadon
10-1-2019
CMSC-255-001
 */

package Project_4;

import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userAnswer;
        do {

            /*
            * processData () { ... }
             */

            processData(in);

            /*
            *   PRINT "Do you want to convert another temperature amount? Enter quit to exit"
            *   userAnswer = INPUT
             */

            System.out.println("Do you want to convert another temperature amount? Enter quit to exit.");
            userAnswer = in.nextLine();

        } while (!userAnswer.equals("quit"));
    }

    public static void processData(Scanner in) {

        /*
        * PRINT "Enter the temperature to convert:"
        * double userTemp = INPUT
         */

        System.out.println("Enter the temperature to convert:");
        double userTemp = in.nextDouble();
        in.nextLine();

        /*
        * PRINT "Enter the current scale of the temperature:"
        * String userScale = INPUT
         */

        System.out.println("Enter the current scale of the temperature:");
        String userScale = in.nextLine();

        /*
        * PRINT "Enter the scale you want to convert the temperature to:"
        * String userConvert = INPUT
         */

        System.out.println("Enter the scale you want to convert the temperature to:");
        String userConvert = in.nextLine();

        /*
        * boolean valid = checkValidity (userTemp, userScale) { ... }
        * IF (valid) { ... }
         */

        if (checkValidity(userTemp, userScale)) {
            double convertedTemp = 0;
            if (!checkValidity(0, userConvert)) {
                System.out.printf("%s is not a valid conversion scale\n", userConvert);
                return;
            }

            /*
            * // Perform the actual calculations via one of the 6 methods
            * convertedTemp = convert()
            * PRINT "{userTemp} degrees {userScale} is {convertedTemp} degrees {userConvert}"
             */

            // These nested switches determine the right method to use for converting
            switch (userScale) {
                // User is converting from Fahrenheit
                case "Fahrenheit":
                    switch (userConvert) {
                        // Converting to Celsius
                        case "Celsius":
                            convertedTemp = convertFahtoCel(userTemp);
                            break;
                        // Converting to Kelvin
                        case "Kelvin":
                            convertedTemp = convertFahtoKel(userTemp);
                            break;
                        // Converting to the same scale
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
                // User is converting from Celsius
                case "Celsius":
                    switch (userConvert) {
                        // Converting to Fahrenheit
                        case "Fahrenheit":
                            convertedTemp = convertCeltoFah(userTemp);
                            break;
                        // Converting to Kelvin
                        case "Kelvin":
                            convertedTemp = convertCeltoKel(userTemp);
                            break;
                        // Converting to the same scale
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
                // User is converting from Kelvin
                case "Kelvin":
                    switch (userConvert) {
                        // Converting to Fahrenheit
                        case "Fahrenheit":
                            convertedTemp = convertKeltoFah(userTemp);
                            break;
                        // Converting to Celsius
                        case "Celsius":
                            convertedTemp = convertKeltoCel(userTemp);
                            break;
                        // Converting to the same scale
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
            }
            System.out.printf("%.2f degrees %s is %.2f degrees %s\n", userTemp, userScale, convertedTemp, userConvert);
        }

        /*
        * ELSE {
        *   PRINT "{userTemp} degrees {userScale} is not a valid temperature"
        * }
         */

        else {
            System.out.println(userTemp + " degrees " + userScale + " is not a valid temperature");
        }

    }

    /*
    * checkValidity (userTemp, userScale) {
    *    IF ((userScale == "Fahrenheit") && (-479.4 <= userTemp <= 1000)) {
    *        return true;
    *    } ELSE IF ((userScale == "Celsius") && (-273 <= userTemp <= 1000)) {
    *        return true;
    *    } ELSE IF ((userScale == "Kelvin") && (0 <= userTemp <= 1000)){
    *        return true;
    *    } ELSE {
    *        return false;
    *    } END IF
    * } END checkValidity
     */

    public static boolean checkValidity(double temp, String scale) {
        switch (scale) {
            case "Fahrenheit":
                return temp >= -479.4 && temp <= 1000;
            case "Celsius":
                return temp >= -273 && temp <= 1000;
            case "Kelvin":
                return temp >= 0 && temp <= 1000;
            default:
                return false;
        }
    }

    public static double convertFahtoCel(double temp) {
        return (temp - 32.0) / (9.0 / 5.0);
    }

    public static double convertCeltoFah(double temp) {
        return (temp * (9.0 / 5.0)) + 32;
    }

    public static double convertFahtoKel(double temp) {
        return convertCeltoKel(convertFahtoCel(temp));
    }

    public static double convertCeltoKel(double temp) {
        return temp + 273;
    }

    public static double convertKeltoCel(double temp) {
        return temp - 273;
    }

    public static double convertKeltoFah(double temp) {
        return convertCeltoFah(convertKeltoCel(temp));
    }
}
