package Projects.Project_7;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")
public class Flight {

    private String year;
    private String startCity;
    private String endCity;
    private double price;
    private int distance;

    public Flight() {
        this.year = "1970";
        this.startCity = "Boston";
        this.endCity = "Richmond";
        this.price = 40.0;
        this.distance = 900;
    }

    public Flight(String year, String startCity, String city2, double price, int distance) {
        this.year = year;
        this.startCity = startCity;
        this.endCity = city2;
        this.price = price;
        this.distance = distance;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(flight.price, price) == 0 &&
                distance == flight.distance &&
                Objects.equals(year, flight.year) &&
                Objects.equals(startCity, flight.startCity) &&
                Objects.equals(endCity, flight.endCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, startCity, endCity, price, distance);
    }

    public String toString() {

        return this.year +
                " " +
                this.startCity +
                " " +
                this.endCity +
                " " +
                this.price +
                " " +
                this.distance;
    }
}
