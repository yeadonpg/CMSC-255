package Lab_12;

import java.time.Month;

public class DriversLicense extends IDCard {

    private int expirationYear;
    private Month expirationMonth;

    public DriversLicense() {
        super();
        this.expirationYear = 1969;
        this.expirationMonth = Month.JANUARY;
    }

    public DriversLicense(String name, int idNumber, int expirationYear, Month expirationMonth) {
        super(name, idNumber);
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
    }

    public String toString() {
        String output = super.toString() + " Expiration Month & Year: ";
        return output + (this.expirationMonth + " " + this.expirationYear);
    }
}
