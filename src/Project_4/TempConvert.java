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
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String userAnswer = "";
        do {
            processData();
            System.out.println("Do you want to convert another temperature amount? Enter quit to exit.");
            userAnswer = in.nextLine();
        } while (!userAnswer.equals("quit"));
    }

    public static void processData() {
        System.out.println("Enter the temperature to convert:");
        double userTemp = in.nextInt();
        in.nextLine();
        System.out.println("Enter the current scale of the temperature:");
        String userScale = in.nextLine();
        System.out.println("Enter the scale you want to convert the temperature to:");
        String userConvert = in.nextLine();
        if (checkValidity(userTemp, userScale)) {
            double convertedTemp = 0;
            if (!checkValidity(0, userConvert)) {
                System.out.printf("%s is not a valid conversion scale\n", userConvert);
                return;
            }
            switch (userScale) {
                case "Fahrenheit":
                    switch (userConvert) {
                        case "Celsius":
                            convertedTemp = convertFahtoCel(userTemp);
                            break;
                        case "Kelvin":
                            convertedTemp = convertFahtoKel(userTemp);
                            break;
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
                case "Celsius":
                    switch (userConvert) {
                        case "Fahrenheit":
                            convertedTemp = convertCeltoFah(userTemp);
                            break;
                        case "Kelvin":
                            convertedTemp = convertCeltoKel(userTemp);
                            break;
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
                case "Kelvin":
                    switch (userConvert) {
                        case "Fahrenheit":
                            convertedTemp = convertKeltoFah(userTemp);
                            break;
                        case "Celsius":
                            convertedTemp = convertKeltoCel(userTemp);
                            break;
                        default:
                            convertedTemp = userTemp;
                            break;
                    }
                    break;
            }
            System.out.printf("%.2f degrees %s is %.2f degrees %s\n", userTemp, userScale, convertedTemp, userConvert);
        }
        else {
            System.out.println(userTemp + " degrees " + userScale + " is not a valid temperature");
        }
    }

    public static boolean checkValidity(double temp, String scale) {
        switch (scale) {
            case "Fahrenheit":
                if (temp >= -479.4 && temp <= 1000) {return true;}
                return false;
            case "Celsius":
                if (temp >= -273 && temp <= 1000) {return true;}
                return false;
            case "Kelvin":
                if (temp >= 0 && temp <= 1000) {return true;}
                return false;
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
