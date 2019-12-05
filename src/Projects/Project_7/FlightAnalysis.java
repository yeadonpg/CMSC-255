package Projects.Project_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightAnalysis {

    public static ArrayList<Flight> parseData(File inputFile) {
        ArrayList<Flight> output = new ArrayList<>();

        try {
            Scanner reader = new Scanner(inputFile);

            while (reader.hasNextLine()) {
                String nextLine = reader.nextLine();
                String[] lineData = nextLine.split(";");

                try {
                    Integer.parseInt(lineData[0]);
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                    continue;
                }

                String year = lineData[0];
                String city1 = lineData[1];
                String city2 = lineData[2];

                double mkt_fare;
                try {
                    mkt_fare = Double.parseDouble(lineData[3]);
                    if (mkt_fare < 0) {
                        mkt_fare = 0;
                    }
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                    mkt_fare = 0.0;
                }

                int distance;
                try {
                    distance = Integer.parseInt(lineData[4]);
                    if (distance < 0) {
                        distance = 0;
                    }
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                    distance = 0;
                }

                Flight newFlight = new Flight(year, city1, city2, mkt_fare, distance);

                output.add(newFlight);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void removeData(ArrayList<Flight> allFlights, ArrayList<Flight> removeItems) {

        allFlights.removeIf(removeItems::contains);

    }

    public static Flight calcBestFare(ArrayList<Flight> allFlights) {
        Flight bestFlight = new Flight("", "", "", 10000.0, 1);
        for (Flight flight : allFlights) {
            if (flight.getPrice() < bestFlight.getPrice()) {
                bestFlight = flight;
            }
        }
        return bestFlight;
    }

    public static Flight calcBestFarePerMile(ArrayList<Flight> allFlights) {
        Flight bestFlight = new Flight("", "", "", 10000.0, 1);
        for (Flight flight : allFlights) {
            if ((flight.getPrice() / flight.getDistance()) < (bestFlight.getPrice() / bestFlight.getDistance())) {
                bestFlight = flight;
            }
        }
        return bestFlight;
    }

    public static void writeOutData(ArrayList<Flight> goodInputArrayList, File outputFile) {
        PrintWriter out;
        try {
            out = new PrintWriter(outputFile);

            for (Flight flight : goodInputArrayList) {
                out.println(flight.toString());
            }
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
